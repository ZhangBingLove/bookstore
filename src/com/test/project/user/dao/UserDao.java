package com.test.project.user.dao;

import com.test.project.user.domain.User;

/**
 * 数据库操作
 */
public interface UserDao {

    /**
     * 添加用户
     */
    void addUser(com.test.project.user.domain.User user);


    /**
     * 查找用户
     */
    User findUser(com.test.project.user.domain.User user);

}
