package com.distribuida.service;

import com.distribuida.db.Book;

import java.util.List;

public interface IBookService {

    Book createBook(Book book);

    Book findBookById(Integer id);

    List<Book> findAllBooks();

    Book updateBook(Book book);

    Integer deleteBook(Integer id);

}
