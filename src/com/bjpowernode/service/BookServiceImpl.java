package com.bjpowernode.service;

import com.bjpowernode.bean.Book;
import com.bjpowernode.dao.BookDao;
import com.bjpowernode.dao.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookDao bd = new BookDaoImpl();
    //添加书籍方法
    @Override
    public int addbook(Book book) {
        return bd.addbook(book);
    }

    @Override
    public List<Book> selectAll() {
        return bd.selectAll();
    }

    @Override
    public Book selectById(int id) {
        return bd.selectById(id);
    }

    @Override
    public List<Book> selectByCond(Book book) {
        return bd.selectByCond(book);
    }

    @Override
    public int updateBook(Book book) {
        return bd.updateBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bd.deleteBook(id);

    }
}
