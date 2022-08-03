package com.kob.backend.service.user.bot;

import com.kob.backend.pojo.Bot;

import java.util.List;
import java.util.Map;

/**
 * @program: backend
 * @description: 查询bot列表
 * @author: WRF
 * @create: 2022-08-03 20:24
 **/
public interface GetListService {
    List<Bot> getList();
}
