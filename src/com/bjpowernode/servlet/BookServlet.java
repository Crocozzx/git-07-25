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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SuppressWarnings({"all"})
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String me = request.getParameter("me");//这里是null
        if ("addBook".equals(me)){
            this.addBook(request,response);
        }else if ("selectAll".equals(me)){
            this.selectAll(request,response);
        }else if ("selectByCond".equals(me)){
            this.selectByCond(request,response);
        }else if ("preUpdate".equals(me)){
            this.selectById(request,response);
        }else if ("updateBook".equals(me)){
            this.updateBook(request,response);
        }else if ("deleteById".equals(me)){
            this.deleteById(request,response);
        }
    }

    private void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer id1 = Integer.parseInt(id);
        BookService bs = new BookServiceImpl();
        int i = bs.deleteBook(id1);
        if (i>0){
            response.sendRedirect("BookServlet?me=selectAll");
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("删除失败");
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            response.sendRedirect("BookServlet?me=selectAll");//你这里直接重定向到selectall.jsp中不行，因为不是一次请求。重定向过去什么数据也没有
        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("修改失败");
        }
    }

    private void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    //条件查询
    private void selectByCond(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = request.getParameter("id");不能根据id进行查询
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");//200
        Date date = null;
        if (bookdate != null && !("".equals(bookdate.trim()))){
            date = DToSUtil.strToD(bookdate);
        }

        int price = 0;
        if (bookprice != null && !("".equals(bookprice.trim()))){
            price = Integer.parseInt(bookprice);
        }
        Book b = new Book(booknum,bookname,bookauthor,bookpublish,date,price);
        BookService bs = new BookServiceImpl();
        List<Book> books = bs.selectByCond(b);//这个返回list的和直接返回对象的不一样，返回对象的查不到是null，返回list的查不到不是null
        //System.out.println(books.size());//0   由此可见，查不到时也会创建出来集合对象，但是集合的个数是0
        request.setAttribute("books",books);
//        request.getRequestDispatcher("selectbydond2.jsp").forward(request,response);
        //这里不需要重新写一个页面，直接写之前那个查询全部的就行
        request.getRequestDispatcher("selectall.jsp").forward(request,response);
    }

    //查询全部
    private void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bs = new BookServiceImpl();
        List<Book> books = bs.selectAll();
            //查询出来，跳转到selectall页面
        request.setAttribute("books",books);
        request.getRequestDispatcher("selectall.jsp").forward(request,response);
    }
    //添加
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String booknum = request.getParameter("booknum");
        String bookname = request.getParameter("bookname");
        String bookauthor = request.getParameter("bookauthor");
        String bookpublish = request.getParameter("bookpublish");
        String bookdate = request.getParameter("bookdate");
        String bookprice = request.getParameter("bookprice");
//        Date date = DToSUtil.strToD(bookdate);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = s.parse(bookdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(parse);
        Book b = new Book(booknum,bookname,bookauthor,bookpublish,parse,Integer.parseInt(bookprice));
        BookService bs = new BookServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        int count = bs.addbook(b);
        if (count > 0){
            //response.sendRedirect("index.jsp");
            response.sendRedirect("BookServlet?me=selectAll");
        }else {
            response.getWriter().println("添加失败");
        }

    }
}
