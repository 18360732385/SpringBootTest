/**
 * Copyright (C), 2019
 * FileName: SecurityConfig
 * Author:   zhangjian
 * Date:     2019/10/10 15:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.config;

import com.zj.sec.filter.VerifyCodeFilter;
import com.zj.sec.handler.MyAuthenticationEntryPoint;
import com.zj.sec.handler.MyAuthenticationFailureHandler;
import com.zj.sec.handler.MyAuthenticationSuccessHandler;
import com.zj.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    VerifyCodeFilter verifyCodeFilter;

    @Autowired
    UserService userService;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //下面这两行配置表示在内存中配置了两个用户
//        auth.inMemoryAuthentication()
//            .withUser("javaboy").roles("admin").password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe")
//            .and()
//            .withUser("lisi").roles("user").password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");

        auth.userDetailsService(userService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);

        http
        .authorizeRequests()//开启登录配置
        .antMatchers("/admin/**").hasRole("admin")//表示访问hello接口，需要admin权限
        .antMatchers("/db/**").hasRole("dba")
        .antMatchers("/user/**").hasRole("user")
        .anyRequest().authenticated()//表示其他接口登录后就能访问

        .and()
        .formLogin()
        //.loginPage("/login") //定义登录界面
        .loginProcessingUrl("/login")//登录处理接口
        .successHandler(myAuthenticationSuccessHandler)//登录成功处理器
        .failureHandler(myAuthenticationFailureHandler)//登录失败处理器
        .permitAll()//和表单登录相关接口全部放行

        .and()
        .logout()
        .logoutUrl("/logout")
//        .logoutSuccessHandler(null)//登出成功处理器
        .permitAll()

        .and()
        .httpBasic().authenticationEntryPoint(myAuthenticationEntryPoint)//用户未登陆处理器

        .and()
        .csrf().disable();//去掉csrf



    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //过滤以下地址(验证码)，不走security
        web.ignoring().antMatchers("/verCode");
        //.antMatchers("/doLogin");
    }
}
