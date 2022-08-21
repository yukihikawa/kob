package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: backend
 * @description: 对局记录
 * @author: WRF
 * @create: 2022-08-17 20:57
 **/
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
