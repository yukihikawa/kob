package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @program: backend
 * @description: 注册
 * @author: WRF
 * @create: 2022-07-27 16:47
 **/
public interface RegisterService {
    Map<String, String> register(String username, String password, String confirmedPassword);
}
