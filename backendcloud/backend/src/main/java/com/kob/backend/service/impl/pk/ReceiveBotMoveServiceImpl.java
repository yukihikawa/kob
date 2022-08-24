package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.consumer.utils.Game;
import com.kob.backend.service.pk.ReceiveBotMoveService;
import org.springframework.stereotype.Service;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-24 17:49
 **/
@Service
public class ReceiveBotMoveServiceImpl implements ReceiveBotMoveService {
    @Override
    public String reveiveBotMove(Integer userId, Integer direction) {
        System.out.println("receive bot move: " + userId + " " + direction + " ");
        if(WebSocketServer.users.get(userId) != null){
            Game game = WebSocketServer.users.get(userId).game;
            if(game != null){
                if(game.getPlayerA().getId().equals(userId)){
                    game.setNextStepA(direction);
                }else if(game.getPlayerB().getId().equals(userId)){
                    game.setNextStepB(direction);
                }
            }
        }
        return "receive bot move success";
    }
}