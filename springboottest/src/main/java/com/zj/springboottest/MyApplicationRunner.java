/**
 * Copyright (C), 2019
 * FileName: MyApplicationRunner
 * Author:   zhangjian
 * Date:     2019/7/16 16:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    Receiver receiver;

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        System.out.println("===========自启动==========");

    }
}

