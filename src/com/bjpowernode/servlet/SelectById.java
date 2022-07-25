package com.bjpowernode.servlet;

import com.bjpowernode.bean.Book;
import com.bjpowernode.service.BookService;
import com.bjpowernode.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectById")
public class SelectById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        BookService bs = new BookServiceImpl();
        Book book = bs.selectById(i);
        if (book != null){//不为null时，进行转发页面
            request.setAttribute("book",book);
            request.getRequestDispatcher("selectbyid2.jsp").forward(request,response);
        }else {//查询是null的时候，打印插叙为空
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("查询是null");
        }
    }
}
