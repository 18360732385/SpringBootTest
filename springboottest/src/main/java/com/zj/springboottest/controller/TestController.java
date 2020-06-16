/**
 * Copyright (C), 2019
 * FileName: TestController
 * Author:   zhangjian
 * Date:     2019/8/15 13:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.controller;

import com.zj.springboottest.annotation.ParamsNotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/test")
    //注解不要加，在参数类型前边加上
    public String test(@ParamsNotNull String userId, @RequestParam String name) {
        return "ok";
    }
}


