/**
 * Copyright (C), 2019
 * FileName: CustomFilterInvocationSecurityMetadataSource
 * Author:   zhangjian
 * Date:     2019/10/14 10:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.filter;

import com.zj.sec.mapper.PathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 校验请求权限过滤器
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    PathMapper pathMapper;

    /**
     * @param o
     * @return
     * @throws IllegalArgumentException
     * 获取当前请求路径，需要的角色权限
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("请求路径： "+requestUrl);

        List<String> roleOfPath = pathMapper.getPathByRole();
        for (String path:roleOfPath){
            if (antPathMatcher.match(path,requestUrl)){

            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
