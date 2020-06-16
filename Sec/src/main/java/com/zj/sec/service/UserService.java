/**
 * Copyright (C), 2019
 * FileName: UserService
 * Author:   zhangjian
 * Date:     2019/10/12 15:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zj.sec.service;

import com.zj.sec.entity.User;
import com.zj.sec.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("账户不存在！");
        }

        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        System.out.println("UserService: " + user.toString());
        return user;
    }
}
