package com.test.project.reqandresp;

import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Random;

/**
 * 测试请求和响应
 */
public class ServletRequestDemo1 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("*****************");

        // text1(req, resp);
//        test2(resp);
//        test3(resp);
//        test4(resp);
//        test7(req);
//        test8(req);
        test10(req);
    }

    /**
     * 使用框架解析
     *
     * @param request
     */
    private void test10(HttpServletRequest request) {
        try {
            User u = new User();
            System.out.println("封装数据前：" + u);
            BeanUtils.populate(u, request.getParameterMap());

            System.out.println("封装数据后：" + u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转发和重定向的区别
     *
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void text9(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String str = "aaaaaa";
        System.out.println("A:我想办事");
        System.out.println("B:我办不了,但我可以找人帮你办");

        //将非表单的数据添加到request的域中
        req.setAttribute("s", str);
        //将请求转发到Demo6中
//        req.getRequestDispatcher("/servletrequestdemo2").forward(req, resp);
//        // 注意: 转发不能跳转到其他应用
//        req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
        //使用重定向可以跳转到其他应用
//        resp.sendRedirect(req.getContextPath() + "/servletrequestdemo2");
//        resp.sendRedirect("http://www.baidu.com");

        req.getRequestDispatcher("/servletrequestdemo2").include(req, resp);


        System.out.println("B:事办完了");

    }

    /**
     * 获取所有请求头信息
     *
     * @param request
     */
    private void test8(HttpServletRequest request) {
        //获得所有请求消息头的name
        Enumeration names = request.getHeaderNames();

        while (names.hasMoreElements()) {
            String e = (String) names.nextElement();
            System.out.println(e + ":" + request.getHeader(e));
        }
    }

    /**
     * 获得请求消息头的信息
     *
     * @param request
     */
    private void test7(HttpServletRequest request) {
        //获得请求消息头的信息
        String header = request.getHeader("User-Agent");
        System.out.println(header);

        if (header.toLowerCase().contains("msie")) {
            System.out.println("你使用的是IE浏览器");
        } else if (header.toLowerCase().contains("firefox")) {
            System.out.println("你使用的是火狐浏览器");
        } else if (header.toLowerCase().contains("chrome")) {
            System.out.println("你使用的是谷歌浏览器");
        } else {
            System.out.println("你使用的是其它浏览器");
        }
    }

    /**
     * 测试响应
     */
    private void text6(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        //设置编码风格
        resp.setContentType("text/html;charset=UTF-8");

        //		getMethod(); 获得请求方式
//		***getRequestURL();返回客户端发出请求时的完整URL。
//		***getRequestURI(); 返回请求行中的资源名部分。
//		*****getContextPath(); 当前应用的虚拟目录 /day09_01_HttpServletRequest
//		getQueryString() ; 返回请求行中的参数部分。

        System.out.println(request.getMethod());//  GET
        System.out.println(request.getRequestURL()); // http://localhost:8080/day09_01_HttpServletRequest/servlet/demo1
        System.out.println(request.getRequestURI()); //   /day09_01_HttpServletRequest/servlet/demo1
        System.out.println(request.getContextPath()); //  /day09_01_HttpServletRequest
        System.out.println(request.getQueryString()); //  username=tom

    }


    /**
     * 测试重定向
     *
     * @param resp
     */
    private void test5(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/bookstore_war_exploded/servletrequestdemo2");
    }


    /**
     * 设置1秒刷新一次
     *
     * @param resp
     * @throws IOException
     */
    private void test4(HttpServletResponse resp) throws IOException {

        resp.setIntHeader("refresh", 1);//设置1秒钟刷新一次

        Random r = new Random();

        resp.getWriter().write(r.nextInt() + "");
    }

    /**
     * 测试自动跳转
     *
     * @param resp
     * @throws IOException
     */
    private void test3(HttpServletResponse resp) throws IOException {
        resp.getWriter().write("注册成功！3秒钟跳到主页");
        //设置3秒钟跳转
        resp.setHeader("refresh", "3;url=/bookstore_war_exploded/servletrequestdemo2");
    }

    /**
     * 画一个验证码
     *
     * @param response
     * @throws IOException
     */
    private void test2(HttpServletResponse response) throws IOException {

        //告诉客户端不使用缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setIntHeader("expires", 0);

        int width = 110;
        int height = 25;
        //在内存中创建一个图像对象
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //创建一个画笔
        Graphics g = img.getGraphics();

        //给图片添加背景色
        g.setColor(Color.PINK);//设置一个颜色
        g.fillRect(1, 1, width - 2, height - 2);//填充颜色

        //给边框一个色
        g.setColor(Color.RED);
        g.drawRect(0, 0, width - 1, height - 1);//设置边框的显示坐标

        //设置文本样式
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));

        //给图片添加文本
        Random rand = new Random();
        int position = 20;
        for (int i = 0; i < 4; i++) {
            g.drawString(rand.nextInt(10) + "", position, 20);//给图片填充文本
            position += 20;
        }

        //添加9条干扰线
        for (int i = 0; i < 9; i++) {
            g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
        }
        //将图片对象以流的方式输出的客户端
        ImageIO.write(img, "jpg", response.getOutputStream());
    }

    /**
     * 下载图片资源
     */

    private void text2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //通过路径得到一个输入流
        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/classes/安卓图标.jpg");
        FileInputStream fis = new FileInputStream(path);

        //创建字节输出流
        ServletOutputStream sos = resp.getOutputStream();

        //得到要下载的文件名
        String fileName = path.substring(path.lastIndexOf("/") + 1);

        //设置文件名的编码
        fileName = URLEncoder.encode(fileName, "UTF-8");

        //告知客户端要下载的文件
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        resp.setHeader("content-type", "image/jpeg");

        //执行输出操作
        int len = 1;
        byte[] b = new byte[1024];

        while ((len = fis.read(b)) != -1) {
            sos.write(b, 0, len);
        }

        sos.close();
        fis.close();

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


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("#################");
        doGet(req, resp);
    }
}
