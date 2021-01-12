package com.offcn.bookshop.service;

import com.offcn.bookshop.bean.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    public List<Book> findAll() throws SQLException;

    public void addBook(Book book) throws SQLException;

    public void updateBook(Book book) throws SQLException;

    public void delectBookById(Integer id) throws SQLException;

    public Book findById(Integer id ) throws SQLException;
}
