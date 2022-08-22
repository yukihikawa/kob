package com.kob.botrunningsystem.service.impl;

import com.kob.botrunningsystem.service.BotRunningService;
import com.kob.botrunningsystem.service.impl.utils.BotPool;
import org.springframework.stereotype.Service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-22 19:54
 **/
@Service
public class BotRunningServiceImpl implements BotRunningService {

    public final static BotPool botPool = new BotPool();


    @Override
    public String addBot(Integer userId, String botCode, String input) {
        System.out.println("add Bot" + userId + " " + botCode + " " + input);
        botPool.addBot(userId, botCode, input);
        return "add bot success";
    }
}
