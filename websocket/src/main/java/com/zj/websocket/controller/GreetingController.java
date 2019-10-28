/**
 * Copyright (C), 2019
 * FileName: GreetingController
 * Author:   zhangjian
 * Date:     2019/10/16 19:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.websocket.controller;

import com.zj.websocket.entiy.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message){
        return message;
    }
}
