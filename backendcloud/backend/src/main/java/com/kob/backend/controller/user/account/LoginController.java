package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: backend
 * @description: 登录模块
 * @author: WRF
 * @create: 2022-07-27 20:24
 **/
@RestController
@Api
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/user/account/token/")
    @ApiOperation(value = "登录")
    public Map<String, String> getToken(@RequestParam Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username, password);
    }

}
