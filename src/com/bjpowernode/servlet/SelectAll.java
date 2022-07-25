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
import java.util.List;

@WebServlet("/SelectAll")
public class SelectAll extends HttpServlet {
//    查询全部
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bs = new BookServiceImpl();
        List<Book> books = bs.selectAll();
        if (books != null){
            //查询出来，跳转到selectall页面
            request.setAttribute("books",books);
            request.getRequestDispatcher("selectall.jsp").forward(request,response);
        }else {
            //查询不出来，打印查询为空
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("查询为空");
        }
    }
}
