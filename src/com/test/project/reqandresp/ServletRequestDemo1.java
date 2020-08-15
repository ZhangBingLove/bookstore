package com.test.project.reqandresp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试响应
 */
public class ServletRequestDemo1 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        text1(req, resp);

    }

    /**
     * 测试响应
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    private void text1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //设置编码风格
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.write("你好");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
