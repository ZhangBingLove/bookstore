package com.test.project.cookieandsession.session;

import com.test.project.cookieandsession.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 展示购物车
 */
public class ShowCart extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("购物车有以下商品: <br>");
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("cart");

        if (books == null) {

            out.write("什么都没买呢 !");
            response.setHeader("refresh", "2; url=" + request.getContextPath() + "/showAllBooksServlet");
        } else {
            for (Book book : books) {
                out.write(book.getName() + " <br>");
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
