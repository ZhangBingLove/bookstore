package com.test.project.jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 负责登录的Servlet
 */
public class DoLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (name.equals("tom") && password.equals("123")) {
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
//            req.getRequestDispatcher("/jsplogin/success.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/jsplogin/success.jsp");
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("/jsplogin/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
