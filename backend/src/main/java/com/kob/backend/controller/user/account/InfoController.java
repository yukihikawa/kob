package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: backend
 * @description: 用户信息
 * @author: WRF
 * @create: 2022-07-27 21:47
 **/

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/user/account/info/")
    public Map<String, String> getInfo(){
        return infoService.getInfo();
    }


}
