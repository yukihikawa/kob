package com.kob.matchingsystem.service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-20 21:30
 **/
public interface MatchingService {
    String addPlayer(Integer userId, Integer rating);

    String removePlayer(Integer userId);
}
