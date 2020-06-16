/**
 * Copyright (C), 2019
 * FileName: CheckParamsInterceptor
 * Author:   zhangjian
 * Date:     2019/8/15 13:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.springboottest.handler;

import com.zj.springboottest.annotation.ParamsNotNull;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 参数检查注解拦截器
 */
public class CheckParamsInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(CheckParamsInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            logger.warn("UnSupport handler");
            return true;
        }
        //List<String> list = getParamsName((HandlerMethod) handler);

        List<String> list = getParamterName((HandlerMethod) handler);


        for (String s : list) {
            String parameter = request.getParameter(s);
            System.out.println(s + "======" + parameter);
            if (StringUtils.isEmpty(parameter)) {
                JSONObject jsonObject = new JSONObject();
                //这个地方是定义缺少参数或者参数为空的时候返回的数据
                jsonObject.put("status", 203);
                jsonObject.put("msg", "缺少必要的" + s + "值");
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", "*");//跨域
                response.getWriter().write(jsonObject.toJSONString());
                return false;
            }
        }
        return true;
    }

    /**
     * 获取使用了该注解的参数名称
     */
    private List getParamsName(HandlerMethod handlerMethod) {
        Parameter[] parameters = handlerMethod.getMethod().getParameters();
        List<String> list = new ArrayList<>();
        for (Parameter parameter : parameters) {
            //判断这个参数时候被加入了 ParamsNotNull. 的注解
            //.isAnnotationPresent()  这个方法可以看一下
            if (parameter.isAnnotationPresent(ParamsNotNull.class)) {
                list.add(parameter.getName());
            }
        }
        return list;
    }

    public static List<String> getParamterName(HandlerMethod handlerMethod) {
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        Method method = ((HandlerMethod) handlerMethod).getMethod();

        String[] params = u.getParameterNames(method);
        return Arrays.asList(params);

    }

}