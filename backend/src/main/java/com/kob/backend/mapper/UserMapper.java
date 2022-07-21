package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: backend
 * @description: usermapper
 * @author: WRF
 * @create: 2022-07-21 21:18
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
