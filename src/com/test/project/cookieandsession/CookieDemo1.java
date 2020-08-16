package com.test.project.cookieandsession;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * cookie
 */
public class CookieDemo1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("CookieDemo1");

        //text1(request, response);
        text2(request, response);

    }

    /**
     * 登录
     *
     * @param request
     * @param response
     */
    private void text2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String userName = "";
        String checked = "";
        //得到客户端保存的cookie数据
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("userName".equals(cookies[i].getName())) {
                userName = cookies[i].getValue();
                checked = "checked='checked'";
            }
        }

        out.write("<form action='" + request.getContextPath() + "/cookiedemo2' method='post'>");
        out.write("用户名：<input type='text' name='userName' value='" + userName + "'/><br/>");
        out.write("密码：<input type='password' name='pwd'/><br/>");
        out.write("<input type='checkbox' name='remember' " + checked + " />记住用户名<br/>");
        out.write("<input type='submit' value='登录'/><br/>");
        out.write("</form>");

    }


    /**
     * 测试cookie方法
     *
     * @param request
     * @param response
     * @throws IOException
     */
    private void text1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        //获取客户端保存的最后访问时间
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastAccessTime".equals(cookies[i].getName())) {
                long l = Long.parseLong(cookies[i].getValue());
                out.write("您的最后访问时间为: " + new Date(l).toLocaleString());
            }
        }

        out.print("<a href='" + request.getContextPath() + "/cookiedemo2'>clear</a>");

        //创建cookie
        Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        //设置cookie的有效时间
//        ck.setMaxAge(60 * 5);
//        ck.setMaxAge(0);
        ck.setPath("/");

        response.addCookie(ck);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
