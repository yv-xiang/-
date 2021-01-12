package com.offcn.bookshop.dao;


import com.offcn.bookshop.bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {

    public List<Book> findAll() throws SQLException;

    public void insterBook(Book book) throws SQLException;

    public void updaeBook(Book book) throws SQLException;

    public void delectBookById(Integer id) throws SQLException;

    public Book findBookById(Integer id) throws SQLException;
}
