package com.kob.backend.service.impl.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.ranklist.GetRanklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @program: backendcloud
 * @description:
 * @author: WRF
 * @create: 2022-08-25 00:36
 **/
public class GetRanklistServiceImpl implements GetRanklistService {
    @Autowired
    UserMapper userMapper;

    @Override
    public JSONObject getList(Integer page) {
        IPage<User> userIPage = new Page<>(page, 3);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("rating");
        List<User> users = userMapper.selectPage(userIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        for(User user : users){
            user.setPassword("");
        }
        resp.put("users", users);
        resp.put("users_count", userMapper.selectCount(null));
        return resp;
    }
}
