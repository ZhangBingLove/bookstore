package com.test.project.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 适配器模式的类,其父类GenericServlet既实现了Servlet又实现了ServletConfig,把需要的方法提供给外面
 * <p>
 * 适配器可以想象成手机充电器
 */
public class GenericServletImpl extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("********** GenericServletImpl **************");
    }
}
