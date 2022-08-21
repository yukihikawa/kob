package com.kob.matchingsystem;

import com.kob.matchingsystem.service.MatchingService;
import com.kob.matchingsystem.service.impl.MatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: backendcloud
 * @description: 入口
 * @author: WRF
 * @create: 2022-08-21 22:43
 **/

@SpringBootApplication
public class MatchingSystemApplication {

    public static void main(String[] args) {
        MatchingServiceImpl.matchingPool.start(); //启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class,args);
    }
}
