package com.test.project.user.service;

import com.test.project.user.domain.User;

public interface UserService {

    /**
     * 注册
     */
    void register(User user);

    /**
     * 登录
     */
    User login(User user);

}
