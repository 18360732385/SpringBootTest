/**
 * Copyright (C), 2020
 * FileName: MessageController
 * Author:   zhangjian
 * Date:     2020/6/16 17:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname MessageController
 * @Description TODO
 * @Date 2020/6/16 17:13
 * @Created by zhangjian
 */
@RequestMapping("/message")
@RestController
public class MessageController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/praise")
    public void praise(@RequestBody String message) {
        rocketMQTemplate.sendOneWay("test", message);
        System.out.println("发送消息："+message);
    }
}
