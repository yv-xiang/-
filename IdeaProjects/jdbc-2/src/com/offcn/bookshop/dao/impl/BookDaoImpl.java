package com.offcn.bookshop.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bookshop.bean.Book;
import com.offcn.bookshop.dao.BookDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
     ComboPooledDataSource dataSource = new ComboPooledDataSource();
     QueryRunner queryRunner = new QueryRunner(dataSource);
    @Override
    public List<Book> findAll() throws SQLException {

        String sql = "select id,booknum,bookname,bookauthor,bookpublish," +
                "bookdate,bookprice from bookshop";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class));
        return list;
    }

    @Override
    public void insterBook(Book book) throws SQLException {
        String sql = "insert into bookshop(booknum,bookname,bookauthor,bookpublish," +
                "bookdate,bookprice)values(?,?,?,?,?,?) ";
        queryRunner.update(sql,book.getBooknum(),book.getBookname(),
                book.getBookauthor(),book.getBookpublish(),book.getBookdate(),book.getBookprice());

    }

    @Override
    public void updaeBook(Book book) throws SQLException {
        String sql = "update bookshop set booknum = ?,bookname = ?,bookauther = ?,bookpublish = ?," +
                "bookdate = ?,bookprice = ? where id = ?";
        queryRunner.update(sql,book.getBooknum(),book.getBookname(),
                book.getBookauthor(),book.getBookpublish(),book.getBookdate(),book.getBookprice(),book.getId());
    }

    @Override
    public void delectBookById(Integer id) throws SQLException {
        String sql = "delete from bookshop where id = ?";
        queryRunner.update(sql,id);
    }

    @Override
    public Book findBookById(Integer id) throws SQLException {
        String sql = "select id , booknum , bookname , bookauthor , bookpublish , bookdate," +
                " bookprice from bookshop where id = ? ";

        Book book  = queryRunner.query(sql, new BeanHandler<>(Book.class),id);

        return book;


    }
}
