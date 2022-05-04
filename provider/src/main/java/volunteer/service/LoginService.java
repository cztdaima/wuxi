package volunteer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volunteer.constant.ReturnMsgEnum;
import volunteer.dao.UsersDao;
import volunteer.entity.Picture;
import volunteer.entity.Users;
import volunteer.mapper.PictureMapper;
import volunteer.mapper.UsersMapper;
import volunteer.param.request.LoginRequestDto;
import volunteer.param.request.RegisterRequestDto;
import volunteer.param.response.ResponseDto;
import volunteer.param.response.dataBody.LoginResponseData;
import volunteer.utils.JacksonUtils;
import volunteer.utils.ResponseDtoUtils;

@Service
public class LoginService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private JacksonUtils jacksonUtils;

    @Autowired
    private ResponseDtoUtils responseDtoUtils;

    public ResponseDto register(RegisterRequestDto registerRequestDto) {
        ResponseDto responseDto = new ResponseDto();
        Users users = new Users();
        BeanUtils.copyProperties(registerRequestDto, users);

        Picture picture = new Picture();
        picture.setPictureUrlAddress(registerRequestDto.getPictureUrlAddress());
        responseDto = responseDtoUtils.setResponseDto(pictureMapper.insert(picture));
        if(responseDto.getCode().equals(ReturnMsgEnum.DATABASE_EXCEPTION.getCode())) {
            return responseDto;
        }

        users.setHeadPortraitId(picture.getPictureId());
        return responseDtoUtils.setResponseDto(usersMapper.insert(users));
    }

    public ResponseDto login(LoginRequestDto loginRequestDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
        Users users = usersDao.selectByWeChatIdAndPhone(loginRequestDto.getWeChatId(), loginRequestDto.getPhoneNo());

        if(users ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        Picture picture = pictureMapper.selectById(users.getHeadPortraitId());
        if(picture ==null) {
            return responseDtoUtils.setResponseDtoWhenNull();
        }

        LoginResponseData loginResponseData = new LoginResponseData();
        BeanUtils.copyProperties(users, loginResponseData);
        loginResponseData.setPictureUrlAddress(picture.getPictureUrlAddress());
        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData(jacksonUtils.objectToString(loginResponseData));
        return responseDto;
    }

}
