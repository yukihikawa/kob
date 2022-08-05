package com.kob.backend.controller.pk;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: backend
 * @description:
 * @author: WRF
 * @create: 2022-07-07 21:33
 **/
@Controller
@Api
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "pk/index.html";
    }
}
