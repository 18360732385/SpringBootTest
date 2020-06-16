/**
 * Copyright (C), 2019
 * FileName: WebMvcConfig
 * Author:   zhangjian
 * Date:     2019/8/15 13:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.config;

import com.zj.springboottest.handler.CheckParamsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    CheckParamsInterceptor checkSourceInterceptor = new CheckParamsInterceptor();

    //增加校验拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 这个地方可以定义拦截器的具体的路径
        registry.addInterceptor(checkSourceInterceptor).addPathPatterns("/**");
    }
}

