package volunteer.controller;

import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteer.param.request.LoginRequestDto;
import volunteer.param.request.RegisterRequestDto;
import volunteer.param.response.ResponseDto;
import volunteer.service.LoginService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/users_register")
    public ResponseDto users_register(HttpServletRequest httpServletRequest, @RequestBody RegisterRequestDto registerRequestDto) {
        return loginService.register(registerRequestDto);
    }

    @PostMapping(value = "/users_login")
    public ResponseDto users_login(HttpServletRequest httpServletRequest, @RequestBody LoginRequestDto loginRequestDto) throws Exception {
        return loginService.login(loginRequestDto);
    }

}
