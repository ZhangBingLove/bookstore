package com.test.project.user.service.impl;

import com.test.project.user.dao.UserDao;
import com.test.project.user.dao.impl.UserDaoImpl;
import com.test.project.user.domain.User;
import com.test.project.user.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册
     */
    @Override
    public void register(User user) {

        userDao.addUser(user);

    }

    /**
     * 登录
     */
    @Override
    public User login(User user) {

        return userDao.findUser(user);

    }
}
