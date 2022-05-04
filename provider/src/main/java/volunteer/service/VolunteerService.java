package volunteer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volunteer.constant.ReturnMsgEnum;
import volunteer.dao.UsersDao;
import volunteer.entity.Picture;
import volunteer.entity.Users;
import volunteer.entity.VolunteerApplication;
import volunteer.entity.VolunteerInfo;
import volunteer.mapper.PictureMapper;
import volunteer.mapper.VolunteerApplicationMapper;
import volunteer.mapper.VolunteerInfoMapper;
import volunteer.param.request.*;
import volunteer.param.response.ResponseDto;
import volunteer.param.response.dataBody.GetVolunteerResponse;
import volunteer.param.response.dataBody.LoginResponseData;
import volunteer.utils.JacksonUtils;
import volunteer.utils.ResponseDtoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerInfoMapper volunteerInfoMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private VolunteerApplicationMapper volunteerApplicationMapper;

    @Autowired
    private ResponseDtoUtils responseDtoUtils;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private JacksonUtils jacksonUtils;

    public ResponseDto saveVolunteer(SaveVolunteerRequestDto saveVolunteerRequestDto) {
        ResponseDto responseDto = new ResponseDto();
        VolunteerInfo volunteerInfo = new VolunteerInfo();
        BeanUtils.copyProperties(saveVolunteerRequestDto, volunteerInfo);

        Picture picture = new Picture();
        picture.setPictureUrlAddress(saveVolunteerRequestDto.getPictureUrlAddress());

        responseDto = responseDtoUtils.setResponseDto(pictureMapper.insert(picture));
        if(responseDto.getCode().equals(ReturnMsgEnum.DATABASE_EXCEPTION.getCode())) {
            return responseDto;
        }

        volunteerInfo.setPictureId(picture.getPictureId());
        return responseDtoUtils.setResponseDto(volunteerInfoMapper.insert(volunteerInfo));
    }

    public ResponseDto getVolunteer(GetVolunteerRequestDto getVolunteerRequestDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        VolunteerInfo volunteerInfo = volunteerInfoMapper.selectById(getVolunteerRequestDto.getVolunteerInfoId());
        if(volunteerInfo ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        Picture picture = pictureMapper.selectById(volunteerInfo.getPictureId());
        if(picture ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        GetVolunteerResponse getVolunteerResponse = new GetVolunteerResponse();
        BeanUtils.copyProperties(volunteerInfo, getVolunteerResponse);
        getVolunteerResponse.setPictureUrlAddress(picture.getPictureUrlAddress());
        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData(jacksonUtils.objectToString(getVolunteerResponse));
        return responseDto;
    }

    public ResponseDto volunteerApply(VolunteerApplyRequestDto volunteerApplyRequestDto) {
        ResponseDto responseDto = new ResponseDto();
        VolunteerApplication volunteerApplication = new VolunteerApplication();
        volunteerApplication.setApplicationStatus("1");
        volunteerApplication.setVolunteerInfoId(volunteerApplyRequestDto.getVolunteerInfoId());
        volunteerApplication.setClaimerId(usersDao.selectByWeChatId(volunteerApplyRequestDto.getWeChatId()).getUserId());

        return responseDtoUtils.setResponseDto(volunteerApplicationMapper.insert(volunteerApplication));
    }

    public ResponseDto volunteerApprove(VolunteerApplyRequestDto volunteerApplyRequestDto) {
        ResponseDto responseDto = new ResponseDto();
        VolunteerApplication volunteerApplication = new VolunteerApplication();
        BeanUtils.copyProperties(volunteerApplyRequestDto, volunteerApplication);

        return responseDtoUtils.setResponseDto(volunteerApplicationMapper.updateById(volunteerApplication));
    }

    public ResponseDto volunteerInfoList(VolunteerInfoListRequestDto volunteerInfoListRequestDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        Users users = usersDao.selectByWeChatId(volunteerInfoListRequestDto.getWeChatId());
        if(users==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        Page<VolunteerInfo> volunteerInfoPage = volunteerInfoMapper.selectPage(new Page<>(volunteerInfoListRequestDto.getPage(), 10), null);
        if(volunteerInfoPage.getRecords() ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData(jacksonUtils.objectToString(volunteerInfoPage.getRecords()));
        return responseDto;
    }

    public ResponseDto ownerVolunteerInfoList(OwnerVolunteerRequestDto ownerVolunteerRequestDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        Users users = usersDao.selectByWeChatId(ownerVolunteerRequestDto.getWeChatId());
        if(users==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }
        QueryWrapper<VolunteerInfo> queryWrapper = new QueryWrapper<VolunteerInfo>();
        queryWrapper.eq("promulgator_id", ownerVolunteerRequestDto.getPromulgatorId());

        Page<VolunteerInfo> volunteerInfoPage = volunteerInfoMapper.selectPage(new Page<>(ownerVolunteerRequestDto.getPage(), 10), queryWrapper);
        if(volunteerInfoPage.getRecords() ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData(jacksonUtils.objectToString(volunteerInfoPage.getRecords()));
        return responseDto;
    }

    public ResponseDto volunteerApprovalPending(VolunteerApprovalPending volunteerApprovalPending) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        Users users = usersDao.selectByWeChatId(volunteerApprovalPending.getWeChatId());
        if(users==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }
        QueryWrapper<VolunteerInfo> volunteerInfoQueryWrapper = new QueryWrapper<VolunteerInfo>();
        volunteerInfoQueryWrapper.eq("promulgator_id", volunteerApprovalPending.getPromulgatorId());

        List<VolunteerInfo> volunteerInfoList = volunteerInfoMapper.selectList(volunteerInfoQueryWrapper);
        if(volunteerInfoList == null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        List<VolunteerApplication> volunteerApplicationListRes = new ArrayList<>();
        for(VolunteerInfo tmp:volunteerInfoList){
            QueryWrapper<VolunteerApplication> volunteerApplicationQueryWrapper = new QueryWrapper<VolunteerApplication>();
            volunteerApplicationQueryWrapper.eq("volunteer_info_id", tmp.getVolunteerInfoId())
                    .eq("application_status", volunteerApprovalPending.getApplicationStatus());

            List<VolunteerApplication> volunteerApplicationList = volunteerApplicationMapper.selectList(volunteerApplicationQueryWrapper);
            if(volunteerApplicationList != null) {
                volunteerApplicationListRes.addAll(volunteerApplicationList);
            }
        }

        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData(jacksonUtils.objectToString(volunteerApplicationListRes.stream().skip(10L * (volunteerApprovalPending.getPage() - 1))
                .limit(10L).collect(Collectors.toList())));
        return responseDto;
    }

}
