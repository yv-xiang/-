package com.offcn.bookshop.bean;

import java.util.Date;

public class Book {
    private Integer id;
    private String booknum;
    private String bookname;
    private String bookauthor;
    private String bookpublish;
    private Date bookdate;
    private Double bookprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooknum() {
        return booknum;
    }

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpublish() {
        return bookpublish;
    }

    public void setBookpublish(String bookpublish) {
        this.bookpublish = bookpublish;
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", booknum='" + booknum + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookpublish='" + bookpublish + '\'' +
                ", bookdate=" + bookdate +
                ", bookprice=" + bookprice +
                '}';
    }
}
