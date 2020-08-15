package com.test.project.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 模板方法设计模式
 */
public class HttpServletImpl extends HttpServlet {

//    private ServletConfig config;
//
//    /**
//     * 第一种方式 init方法获取到ServeletConfig
//     *
//     * @param config
//     * @throws ServletException
//     */
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的ip地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

//        //第二种方式
//        ServletConfig servletConfig = super.getServletConfig();

        //第三种方式
        ServletConfig servletConfig = this.getServletConfig();

        //获取servlet的参数信息
        String encoding = servletConfig.getInitParameter("encoding");
        System.out.println("encoding = " + encoding);

        ServletContext servletContext = getServletContext();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
