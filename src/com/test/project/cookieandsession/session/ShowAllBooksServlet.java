package com.test.project.cookieandsession.session;

import com.test.project.cookieandsession.Book;
import com.test.project.cookieandsession.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShowAllBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("本网站有以下好书: <br>");
        Map<String, Book> allBooks = DBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : allBooks.entrySet()) {
            String url = request.getContextPath() + "/addCart?id=" + book.getKey();
            out.print("<a href='" + response.encodeURL(url) + "' >" + book.getValue().getName() + "</a><br/>");
        }
        String url2 = request.getContextPath() + "/showCart";
        out.print("<a href='" + response.encodeURL(url2) + "'>查看购物车</a>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
