package com.test.project.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet 是运行在 Web 服务器中的小型 Java 程序（即：服务器端的小应用程序）。servlet 通常通过 HTTP（超文本传输协议）接收和响应来自 Web 客户端的请求。
 */
public class ServletImpl implements Servlet {

    public ServletImpl() {
        System.out.println("ServletImpl()执行了");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()执行了");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()执行了");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()执行了");
    }


    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}
