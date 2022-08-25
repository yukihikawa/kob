package com.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-25 00:35
 **/
public interface GetRanklistService {
    JSONObject getList(Integer page);
}
