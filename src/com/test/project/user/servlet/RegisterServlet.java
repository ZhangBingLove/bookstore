package com.test.project.user.servlet;

import com.test.project.user.domain.User;
import com.test.project.user.domain.UserForm;
import com.test.project.user.service.UserService;
import com.test.project.user.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 注册
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取表单数据的验证
        UserForm userForm = new UserForm();
        try {
            BeanUtils.populate(userForm, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!userForm.validate()) {
            req.setAttribute("uf", userForm);
            req.getRequestDispatcher("/user/register.jsp").forward(req, resp);
            return;
        }


        //获取表单数据
        User user = new User();

        try {
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.populate(user, req.getParameterMap());
            //处理业务逻辑
            UserService userService = new UserServiceImpl();
            userService.register(user);
            resp.getWriter().write("注册成功, 1秒后调到主页");
            resp.setHeader("refresh", "1; url=" + req.getContextPath() + "/user/home.jsp");
            //分发转向

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
