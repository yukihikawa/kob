package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @program: backend
 * @description: 登录
 * @author: WRF
 * @create: 2022-07-27 16:46
 **/
public interface LoginService {
    public Map<String, String> getToken(String username, String password);



}
