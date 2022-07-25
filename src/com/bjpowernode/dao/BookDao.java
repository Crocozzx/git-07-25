package com.bjpowernode.dao;

import com.bjpowernode.bean.Book;

import java.util.List;

public interface BookDao {
    //添加书籍方法
    int addbook(Book book);
    //查询全部
    List<Book> selectAll();
    //根据id进行查询
    Book selectById(int id);
    //根据提交的条件进行查询
    List<Book> selectByCond(Book book);
    //修改
    int updateBook(Book book);
    //根据id删除
    int deleteBook(int id);
    //登录


}
