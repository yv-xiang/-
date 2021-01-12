package com.offcn.bookshop.service.impl;

import com.offcn.bookshop.bean.Book;
import com.offcn.bookshop.dao.BookDao;
import com.offcn.bookshop.dao.impl.BookDaoImpl;
import com.offcn.bookshop.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> findAll() throws SQLException {

        return bookDao.findAll();
    }

    @Override
    public void addBook(Book book) throws SQLException {
        bookDao.insterBook(book);
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        bookDao.updaeBook(book);
    }

    @Override
    public void delectBookById(Integer id) throws SQLException {
        bookDao.delectBookById(id);
    }

    @Override
    public Book findById(Integer id) throws SQLException {
        return bookDao.findBookById(id);
    }
}
