package com.kob.backend.controller.pk;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: backend
 * @description:
 * @author: WRF
 * @create: 2022-07-07 21:38
 **/
@RestController
@RequestMapping("/pk/")
@Api
public class BotInfoController {
    @ApiOperation(value = "获取Bot信息")
    @GetMapping("getBotInfo/")
    public Map<String, String> getBotInfo(){
        Map<String, String> bot1 = new HashMap<>();
        bot1.put("name", "tiger");
        bot1.put("rating", "1500");

        return bot1;

    }
}
