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

@SuppressWarnings({"all"})
@WebServlet("/UpdateBook")
public class UpdateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");
        Date bookdate1 = DToSUtil.strToD(bookdate);
        Integer bookprice1 = Integer.parseInt(bookprice);
        Book b = new Book(id1,booknum,bookname,bookauthor,bookpublish,bookdate1,bookprice1);
        BookService bs = new BookServiceImpl();
        int i = bs.updateBook(b);
        if (i > 0){
            response.sendRedirect("index.jsp");//你这里直接重定向到selectall.jsp中不行，因为不是一次请求。重定向过去什么数据也没有
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("修改失败");
        }

    }
}
