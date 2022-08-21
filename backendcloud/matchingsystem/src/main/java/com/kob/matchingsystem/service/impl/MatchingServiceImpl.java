package com.kob.matchingsystem.service.impl;

import com.kob.matchingsystem.service.MatchingService;
import com.kob.matchingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-20 22:01
 **/
@Service
public class MatchingServiceImpl implements MatchingService {

    public final static MatchingPool matchingPool = new MatchingPool();
    @Override
    public String addPlayer(Integer userId, Integer rating) {
        System.out.println("add player: " + userId + " " + rating);
        matchingPool.addPlayer(userId, rating, -1);
        return "add success.";
    }

    @Override
    public String removePlayer(Integer userId) {
        System.out.println("remove user: " + userId);
        matchingPool.removePlayer(userId);
        return "remove success";
    }
}