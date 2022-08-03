package com.kob.backend.service.user.bot;

import java.util.Map;

/**
 * @program: backend
 * @description: 更新bot信息
 * @author: WRF
 * @create: 2022-08-03 20:27
 **/
public interface UpdateService {
    Map<String, String> update(Map<String, String> data);
}
