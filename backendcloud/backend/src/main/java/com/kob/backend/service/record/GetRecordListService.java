package com.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-25 00:37
 **/
public interface GetRecordListService {
    JSONObject getList(Integer page);
}
