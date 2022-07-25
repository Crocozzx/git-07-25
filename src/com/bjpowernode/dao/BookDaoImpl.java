package com.bjpowernode.dao;

import com.bjpowernode.bean.Book;
import com.bjpowernode.util.DBUtil;
import com.bjpowernode.util.DToSUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao{
    //添加书籍方法
    @Override
    public int addbook(Book book) {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql = "insert into book values(null,?,?,?,?,?,?)";
        int i = 0;
        try {
            i = qr.update(sql,book.getBooknum(),book.getBookname(),book.getBookauthor(),book.getBookpublish(),book.getBookdate(),
                    book.getBookprice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //查询全部
    @Override
    public List<Book> selectAll() {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql = "select * from book";
        List<Book> list = null;
        try {
            list = qr.query(sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //根据id进行查询
    @Override
    public Book selectById(int id) {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql = "select * from book where id = ?";
        Book book = null;
        try {
            book = qr.query(sql, new BeanHandler<>(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    //根据提交的条件进行查询
    @Override
    public List<Book> selectByCond(Book book) {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql = this.getSql2(book);
        System.out.println(sql);
        List<Book> list = null;
        try {

            list = qr.query(sql,new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //修改
    @Override
    public int updateBook(Book book) {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql  = "update book set booknum = ?,bookname=?,bookauthor = ?,bookpublish=?,bookdate=?,bookprice=? where id = ?";
        int i = 0;
        try {
            i = qr.update(sql,book.getBooknum(),book.getBookname(),book.getBookauthor(),book.getBookpublish(),book.getBookdate(),
                    book.getBookprice(),book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    //根据id删除数据
    @Override
    public int deleteBook(int id) {
        QueryRunner qr = new QueryRunner(DBUtil.getDs());
        String sql = "delete from book where id = ?";
        int i = 0;
        try {
            i = qr.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //根据提交的条件来进行拼接sql
    public String getSql(Book book){
        String str = "select * from book where 1 = 1 ";
        if (book.getId() != 0){
            str = str+" and id = "+book.getId();
        }
        if (!("".equals(book.getBooknum())) && book.getBooknum() != null){
            str = str+" and booknum like '%"+book.getBooknum()+"%'";
        }
        if (!("".equals(book.getBookname())) && book.getBookname() != null){
            str = str+" and bookname like '%"+book.getBookname()+"%'";
        }
        if (!("".equals(book.getBookauthor())) && book.getBookauthor() != null){
            str = str+" and bookauthor like '%"+book.getBookauthor()+"%'";
        }
        if (!("".equals(book.getBookpublish())) && book.getBookpublish() != null){
            str = str+" and bookpublish like '%"+book.getBookpublish()+"%'";
        }
        if (book.getBookdate() != null){
            str = str+" and bookdate ="+book.getBookdate();
        }
        if (book.getBookprice() != 0){
            str = str+" and bookprice ="+book.getBookprice();
        }
        return str;
    }
    public String getSql2(Book book){
        StringBuilder sb = new StringBuilder( "select * from book where 1 = 1 ");
        if (!("".equals(book.getBooknum().trim())) && book.getBooknum() != null){
            sb.append(" and booknum like '%").append(book.getBooknum()).append("%'");
        }
        if (!("".equals(book.getBookname().trim())) && book.getBookname() != null){
            sb.append(" and bookname like '%").append(book.getBookname()).append("%'");
        }
        if (!("".equals(book.getBookauthor().trim())) && book.getBookauthor() != null){
            sb.append(" and bookauthor like '%").append(book.getBookauthor()).append("%'");
        }
        if (!("".equals(book.getBookpublish().trim())) && book.getBookpublish() != null){
            sb.append(" and bookpublish like '%").append(book.getBookpublish()).append("%'");
        }
        if (book.getBookdate() != null){
            sb.append(" and bookdate = '").append(DToSUtil.dToStr(book.getBookdate())).append("'");
        }
        if (book.getBookprice() != 0){
            sb.append(" and bookprice =").append(book.getBookprice());
        }
        return sb.toString();
    }
}
