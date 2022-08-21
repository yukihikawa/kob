package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.service.pk.StartGameService;
import org.springframework.stereotype.Service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-22 00:39
 **/
@Service
public class StartGameServiceImpl implements StartGameService {
    @Override
    public String startGame(Integer aId, Integer bId) {
        System.out.println("start game: " + aId + " " +bId);
        WebSocketServer.startGame(aId, bId);
        return "start game success";
    }
}
