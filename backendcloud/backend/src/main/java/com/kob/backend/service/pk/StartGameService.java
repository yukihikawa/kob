package com.kob.backend.service.pk;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-22 00:38
 **/
public interface StartGameService {
    String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId);
}
