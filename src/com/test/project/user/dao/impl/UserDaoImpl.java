package com.test.project.user.dao.impl;

import com.test.project.user.dao.UserDao;
import com.test.project.user.domain.User;
import com.test.project.user.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * 用户实现类
 */
public class UserDaoImpl implements UserDao {


    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("INSERT INTO user(username, password, email, birthday)values(?,?, ?, ?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(user.getBirthday());
            ps.setString(4, date);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");

        } finally {
            DBUtils.closeAll(null, ps, connection);

        }


    }

    @Override
    public User findUser(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User u = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                u = new User();
                u.setId(resultSet.getInt(1));
                u.setUsername(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));
                u.setEmail(resultSet.getString(4));
                u.setBirthday(resultSet.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBUtils.closeAll(resultSet, ps, connection);

        }
        return u;
    }
}
