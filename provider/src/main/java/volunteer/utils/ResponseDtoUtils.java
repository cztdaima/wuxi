package volunteer.utils;

import org.springframework.stereotype.Service;
import volunteer.constant.ReturnMsgEnum;
import volunteer.param.response.ResponseDto;

@Service
public class ResponseDtoUtils {
    public ResponseDto setResponseDto(int result) {
        ResponseDto responseDto = new ResponseDto();
        if(result > 0) {
            responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
            responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        } else {
            responseDto.setCode(ReturnMsgEnum.DATABASE_EXCEPTION.getCode());
            responseDto.setMsg(ReturnMsgEnum.DATABASE_EXCEPTION.getMessage());
        }
        responseDto.setData("");
        return responseDto;
    }

    public ResponseDto setResponseDtoWhenNull() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ReturnMsgEnum.DATABASE_EXCEPTION.getCode());
        responseDto.setMsg(ReturnMsgEnum.DATABASE_EXCEPTION.getMessage());
        responseDto.setData("");
        return responseDto;
    }

}
