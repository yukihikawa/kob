package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: backend
 * @description: 注册
 * @author: WRF
 * @create: 2022-07-27 23:08
 **/
@RestController
public class RegisterController {
    @Autowired
    public RegisterService registerService;

    @PostMapping("/user/account/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map){
        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        return registerService.register(username, password, confirmedPassword);
    }
}
