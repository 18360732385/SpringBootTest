/**
 * Copyright (C), 2020
 * FileName: PraiseListener
 * Author:   zhangjian
 * Date:     2020/6/17 19:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.listener;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * @Classname PraiseListener
 * @Description TODO
 * @Date 2020/6/17 19:14
 * @Created by zhangjian
 */
@Service
@RocketMQMessageListener(topic = "test", consumerGroup = "consumerGp1")
public class PraiseListener implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(String message) {
        System.out.println("消费者消费消息："+message);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        // 每次拉取的间隔，单位为毫秒
        consumer.setPullInterval(2000);
        // 设置每次从队列中拉取的消息数为16
        consumer.setPullBatchSize(16);
    }
}