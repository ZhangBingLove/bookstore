package com.test.project.reqandresp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试响应
 */
public class ServletRequestDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("我是ServletRequestDemo2 - doGet()");
        String s = (String) req.getAttribute("s");
        if (s != null && !s.isEmpty()) {
            System.out.println("C:我有钱,我借给你");
            System.out.println(" s = " + s);
        }

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("我是ServletRequestDemo2 - doPost()");
        doGet(req, resp);

    }
}
