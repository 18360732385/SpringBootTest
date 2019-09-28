/**
 * Copyright (C), 2019
 * FileName: MyWebMvcConfig
 * Author:   zhangjian
 * Date:     2019/8/11 14:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 解决跨域问题Cors
 * allowedOrigins字段可以指定跨域地址
 * 不写或*表示全部通过
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*");
                //.allowedOrigins("http://localhost:8082");
                //.allowedOrigins("*");
    }
}
