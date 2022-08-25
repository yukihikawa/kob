package com.kob.botrunningsystem.service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-22 19:52
 **/
public interface  BotRunningService {
    String addBot(Integer userId, String botCode, String input);
}
