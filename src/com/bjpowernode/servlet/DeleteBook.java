package com.bjpowernode.servlet;

import com.bjpowernode.service.BookService;
import com.bjpowernode.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        BookService bs = new BookServiceImpl();
        int i = bs.deleteBook(id1);
        if (i>0){
            response.sendRedirect("index.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("删除失败");
        }
    }
}
