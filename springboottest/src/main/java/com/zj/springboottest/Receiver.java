/**
 * Copyright (C), 2019
 * FileName: Receiver
 * Author:   zhangjian
 * Date:     2019/5/22 17:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
//消息消费者
public class Receiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("消费者:"+msg);
    }
}
