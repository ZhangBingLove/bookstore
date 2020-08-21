package com.test.project.user.servlet;

import com.test.project.user.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("111111");
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * form student");
            System.out.println(preparedStatement.toString());
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
