/**
 * Copyright (C), 2019
 * FileName: VerifyCodeController
 * Author:   zhangjian
 * Date:     2019/10/11 16:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码
 */
@RestController
public class VerifyCodeController {
    @GetMapping("/verCode")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100,6,60);
        //存入redis中，这里简单放入session
        request.getSession().setAttribute("verCode",lineCaptcha.getCode());

        lineCaptcha.write(response.getOutputStream());
    }

}
