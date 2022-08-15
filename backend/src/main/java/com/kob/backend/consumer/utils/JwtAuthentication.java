package com.kob.backend.consumer.utils;

import com.kob.backend.utils.JwtUtil;
import io.jsonwebtoken.Claims;

/**
 * @program: backend
 * @description: JWT验证
 * @author: WRF
 * @create: 2022-08-14 20:24
 **/
public class JwtAuthentication {


    /**
     * 从token获取userId
     * @param token
     * @return userId
     */
    public static Integer getUserId(String token){
        int userId = -1;
        try{
            Claims claims = JwtUtil.parseJWT(token);
            userId = Integer.parseInt(claims.getSubject());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return userId;
    }
}
