package com.offcn.bookshop.web;

import com.offcn.bookshop.bean.Book;
import com.offcn.bookshop.service.BookService;
import com.offcn.bookshop.service.impl.BookServiceImpl;
import com.offcn.bookshop.utils.DateFormatUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookWeb {
    private static BookService bookService = new BookServiceImpl();

    public BookWeb() throws SQLException {
    }


    public static void main(String[] args) throws SQLException {
        bookView();
    }

    public static void bookView() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[A]查询所有书籍   [B]增加书籍   [C]修改书籍   [D]删除书籍");
            System.out.println("请选择器操作：");
            String gn = sc.nextLine();
            if ("a".equalsIgnoreCase(gn)) {
                //查询所有书籍
//                System.out.println("查询所有书籍");
                List<Book> list = bookService.findAll();
                View(list);
            } else if ("b".equalsIgnoreCase(gn)) {
                //增加书籍
                //System.out.println("增加书籍");
                addBook();
                List<Book> list = bookService.findAll();
                View(list);
            } else if ("c".equalsIgnoreCase(gn)) {
                //修改书籍
                List<Book> list = bookService.findAll();
                View(list);
                updateBookById();
            } else if ("d".equalsIgnoreCase(gn)) {
                //删除书籍
                List<Book> list = bookService.findAll();
                View(list);
                System.out.println("请输入要删除的书籍的id");
                String id = sc.nextLine();
                List<Book> list1 = bookService.findAll();
                View(list1);

            } else {
                //输入编号有误  给出提示
                System.out.println("输入编号有误，请重新输入");
            }
        }
    }

    public static void addBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书籍编号");
        String booknum = scanner.nextLine();
        System.out.println("请输入书籍名称");
        String bookname = scanner.nextLine();
        System.out.println("请输入书籍作者");
        String bookauthor = scanner.nextLine();
        System.out.println("请输入书籍出版社");
        String bookpublish = scanner.nextLine();
        System.out.println("请输入书籍日期");
        String bookdate = scanner.nextLine();
        System.out.println("请输入书籍价格");
        String bookprice = scanner.nextLine();

        Book book = new Book();
        book.setBooknum(booknum);
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookpublish(bookpublish);
        book.setBookdate(DateFormatUtil.stringToDate(bookdate));
        book.setBookprice(Double.parseDouble(bookprice));

        bookService.addBook(book);
    }
    public static void View(List<Book> list) {

        for(Book book : list)
        {
            System.out.println(book);
        }
    }
    public static void updateBookById() throws SQLException {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要修改书籍的id");
            String id = sc.nextLine();
            //根据id查询是否存该id
            Book book = bookService.findById(Integer.parseInt(id));
            if (book != null) {
                while (true) {
                    //更新书籍
                    System.out.println("请选择要更新的字段");
                    System.out.println("[A]编号  [B]书名   [C]作者  [D]出版社   [E]日期   [F]价格   [G]退出");
                    String gn = sc.nextLine();
                    if ("a".equalsIgnoreCase(gn)) {
                        System.out.println("请输入新的书籍编号");
                        String booknum = sc.nextLine();
                        book.setBooknum(booknum);
                    } else if ("b".equalsIgnoreCase(gn)) {
                        System.out.println("请输入书名");
                        String bookname = sc.nextLine();
                        book.setBookname(bookname);
                    } else if ("c".equalsIgnoreCase(gn)) {
                        System.out.println("请输入作者");
                        String bookauthor = sc.nextLine();
                        book.setBookauthor(bookauthor);
                    } else if ("d".equalsIgnoreCase(gn)) {
                        System.out.println("请输入出版社");
                        String bookpublish = sc.nextLine();
                        book.setBookpublish(bookpublish);
                    } else if ("e".equalsIgnoreCase(gn)) {
                        System.out.println("请输入日期");
                        String bookdate = sc.nextLine();
                        book.setBookdate(DateFormatUtil.stringToDate(bookdate));
                    } else if ("f".equalsIgnoreCase(gn)) {
                        System.out.println("请输入价格");
                        String bookprice = sc.nextLine();
                        book.setBookprice(Double.parseDouble(bookprice));
                    } else if ("G".equalsIgnoreCase(gn)) {
                       bookView();
                    } else {
                        System.out.println("请输入正确的功能编号");
                    }

                    //更新并返回到查询列表
                    bookService.updateBook(book);
                    //查询所有书籍
                    List<Book> list = bookService.findAll();

                }
            } else {
                System.out.println("输入功能编号有误，请重新输入");
            }
        }
    }
}