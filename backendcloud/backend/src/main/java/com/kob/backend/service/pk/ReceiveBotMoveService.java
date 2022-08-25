package com.kob.backend.service.pk;

/**
 * @program: backendcloud
 * @description: 接收bot运行系统传过来的结果
 * @author: WRF
 * @create: 2022-08-24 17:46
 **/
public interface ReceiveBotMoveService {
    String receiveBotMove(Integer userId, Integer direction);
}
