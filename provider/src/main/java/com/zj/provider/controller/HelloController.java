/**
 * Copyright (C), 2019
 * FileName: HelloController
 * Author:   zhangjian
 * Date:     2019/8/11 13:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    //@CrossOrigin(value="http://localhost:8081")
    @GetMapping("/hello")
    public String hello() {
        System.out.println("get hello");
        return "hello";
    }

    //@CrossOrigin(value="http://localhost:8081")
    @PostMapping("/hello")
    public String hello2() {
        System.out.println("post hello");
        return "post hello";
    }

}

