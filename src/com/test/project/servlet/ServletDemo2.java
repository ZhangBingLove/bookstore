package com.test.project.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 获取ServletDemo1里传入的
 * <p>
 * 测试获取值和获取全局配置信息
 * <p>
 * 测试获取绝对路径
 */
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        text1();
//        text2();
//        text3();
        text4(req, resp);

    }

    /**
     * 测试Servlet转发
     */
    private void text4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        //参数表示要跳转到哪去
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/servletDemo1");
        requestDispatcher.forward(req, resp);
    }

    /**
     * 测试获取绝对路径
     */
    private void text3() throws IOException {
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/b.properties");
        System.out.println(realPath);

        Properties properties = new Properties();
        properties.load(new FileInputStream(realPath));
        System.out.println(properties.getProperty("name"));

    }

    /**
     * 测试获取绝对路径
     */
    private void text2() throws IOException {
        ServletContext servletContext = this.getServletContext();
        //根据资源名称得到资源的绝对路径.
        String realPath = servletContext.getRealPath("/WEB-INF/a.properties");
        System.out.println(realPath);

        Properties properties = new Properties();
        properties.load(new FileInputStream(realPath));
        System.out.println(properties.getProperty("name"));

    }

    /**
     * 测试获取值和获取全局配置信息
     */
    private void text1() {
        //获取ServletContext
        ServletContext servletContext = this.getServletContext();

        //获取值
        String name = (String) servletContext.getAttribute("name");

        if (name != null && !name.isEmpty()) {
            System.out.println("name = " + name);
        } else {
            System.out.println("name = null");
        }

        //获取全局的配置信息
        String encoding = servletContext.getInitParameter("encoding");
        System.out.println("全局配置信息encoding = " + encoding);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
