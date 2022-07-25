package com.bjpowernode.servlet;

import com.bjpowernode.bean.Book;
import com.bjpowernode.service.BookService;
import com.bjpowernode.service.BookServiceImpl;
import com.bjpowernode.util.DToSUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addbook")
public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");
        Date date = DToSUtil.strToD(bookdate);
        Book b = new Book(booknum,bookname,bookauthor,bookpublish,date,Integer.parseInt(bookprice));
        BookService bs = new BookServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        int addbook = bs.addbook(b);
        if (addbook > 0){
            response.sendRedirect("index.jsp");
        }else {
            response.getWriter().println("添加失败");
        }


    }
}
