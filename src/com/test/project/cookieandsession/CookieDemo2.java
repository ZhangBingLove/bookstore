package com.test.project.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * cookie2
 */
public class CookieDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("CookieDemo2");

//        test1(request, response);
        test2(request, response);
    }

    /**
     * 登录注册
     *
     * @param request
     * @param response
     */
    private void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String remember = request.getParameter("remember");

        Cookie ck = new Cookie("userName", userName);
        ck.setPath("/");
        //处理逻辑
        //分发转向
        if ("tom".equals(userName) && "123".equals(pwd)) {
            if (remember != null) {
                ck.setMaxAge(Integer.MAX_VALUE);
            } else {
                ck.setMaxAge(0);
            }
            response.addCookie(ck);
            out.write("登录成功");
        } else {
            out.write("登录失败");
            response.setHeader("refresh", "2; url=" + request.getContextPath() + "/cookiedemo1");
        }

    }

    /**
     * 清除cookie
     */
    private void test1(HttpServletRequest request, HttpServletResponse response) {
        Cookie ck = new Cookie("lastAccessTime", "");
        ck.setMaxAge(0);
        ck.setPath("/");
        response.addCookie(ck);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
