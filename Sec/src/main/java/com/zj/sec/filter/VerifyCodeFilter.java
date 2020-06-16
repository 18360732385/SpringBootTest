/**
 * Copyright (C), 2019
 * FileName: VerifyCodeFilter
 * Author:   zhangjian
 * Date:     2019/10/11 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.filter;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码过滤器
 */
@Component
public class VerifyCodeFilter extends GenericFilterBean {
    private String defaultFilterProcessUrl = "/doLogin";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        if ("POST".equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
//            // 验证码验证
//            String requestCaptcha = request.getParameter("code");
//            String genCaptcha = (String) request.getSession().getAttribute("verCode");
//
//            if (StringUtils.isEmpty(genCaptcha)){
//                genCaptcha = "123";
//            }
//
//            if (StringUtils.isEmpty(requestCaptcha))
//                throw new AuthenticationServiceException("验证码不能为空!");
//            if (!genCaptcha.toLowerCase().equals(requestCaptcha.toLowerCase())) {
//                throw new AuthenticationServiceException("验证码错误!");            }
//        }

        filterChain.doFilter(request, response);
    }
}
