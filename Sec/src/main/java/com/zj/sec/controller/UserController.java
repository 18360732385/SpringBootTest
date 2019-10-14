/**
 * Copyright (C), 2019
 * FileName: UserController
 * Author:   zhangjian
 * Date:     2019/10/12 16:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.controller;

import com.zj.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/doLogin")
    public UserDetails doLogin(String username, String password) {
        UserDetails userDetails = userService.loadUserByUsername(username);
        System.out.println("UserController: "+userDetails.toString());
        return userDetails;
    }
}
