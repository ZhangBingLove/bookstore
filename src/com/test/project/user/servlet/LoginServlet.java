package com.test.project.user.servlet;

import com.test.project.user.domain.User;
import com.test.project.user.service.UserService;
import com.test.project.user.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = new User();
        //获取表单数据
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserService userService = new UserServiceImpl();
        User login = userService.login(user);

        if (login != null) {
            //如果登录成功 存储session 并跳转到首页
            req.getSession().setAttribute("u", user);
            resp.sendRedirect(req.getContextPath() + "/user/home.jsp");
        }else{
            resp.sendRedirect(req.getContextPath() + "/user/home.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
