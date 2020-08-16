package com.test.project.cookieandsession.session;

import com.test.project.cookieandsession.Book;
import com.test.project.cookieandsession.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AddCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        //根据id得到书
//        String id = request.getParameter("id");
//        Book book = DBUtil.findBookById(id);
//        //得到session对象
//        HttpSession session = request.getSession();
//        //从session中取出list（购物车）
//        List<Book> list = (List<Book>)session.getAttribute("cart");
//        if(list==null){
//            list = new ArrayList<Book>();
//        }
//        list.add(book);
//
//        session.setAttribute("cart", list);//把list放回到session域中
//
//        out.print("购买成功！");
//        String url = request.getContextPath()+"/servlet/showAllBooksServlet";
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //根据id得到书
        String id = request.getParameter("id");
        Book book = DBUtil.findBookById(id);
        //得到session对象
        HttpSession session = request.getSession();
        //从session中取出list(购物车)
        List<Book> list = (List<Book>) session.getAttribute("cart");
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(book);

        session.setAttribute("cart", list);
        out.write("购买成功! ");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
