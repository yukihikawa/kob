package com.kob.botrunningsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: backendcloud
 * @description: 辅助类
 * @author: WRF
 * @create: 2022-08-22 19:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bot {
    Integer userId;
    String botCode;
    String input;
}
