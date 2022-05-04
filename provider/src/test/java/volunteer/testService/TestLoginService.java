package volunteer.testService;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import volunteer.constant.ReturnMsgEnum;
import volunteer.param.request.RegisterRequestDto;
import volunteer.param.response.ResponseDto;
import volunteer.service.LoginService;

@AutoConfigureMockMvc
@Slf4j
public class TestLoginService {

    @Mock
    private LoginService loginService;

    @Test
    void should_pass_when_save_users() {
        loginService = Mockito.mock(LoginService.class);
        RegisterRequestDto registerRequestDto = new RegisterRequestDto();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ReturnMsgEnum.SUCCESS.getCode());
        responseDto.setMsg(ReturnMsgEnum.SUCCESS.getMessage());
        responseDto.setData("");

        Mockito.when(loginService.register(Mockito.any()))
                .thenReturn(responseDto);

        ResponseDto responseMsg = loginService.register(registerRequestDto);
        log.info("{}", responseMsg);
    }

}
