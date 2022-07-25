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
import java.util.List;

@SuppressWarnings({"all"})
@WebServlet("/SelectByCond")
public class SelectByCond extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = request.getParameter("id");不能根据id进行查询
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");//200
        Date date = null;
        if (bookdate != null && !("".equals(bookdate))){
            date = DToSUtil.strToD(bookdate);
        }

        int price = 0;
        if (bookprice != null && !("".equals(bookprice))){
            price = Integer.parseInt(bookprice);
        }
        Book b = new Book(booknum,bookname,bookauthor,bookpublish,date,price);
        BookService bs = new BookServiceImpl();
        List<Book> books = bs.selectByCond(b);//这个返回list的和直接返回对象的不一样，返回对象的查不到是null，返回list的查不到不是null
        System.out.println(books.size());//0   由此可见，查不到时也会创建出来集合对象，但是集合的个数是0
        request.setAttribute("books",books);
        request.getRequestDispatcher("selectbydond2.jsp").forward(request,response);



    }
}
