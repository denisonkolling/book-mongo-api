package com.mongo.book.service;

import com.mongo.book.model.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);

    Boolean delete(String id);

    List<Book> getAll();

    List<Book> getByCriteria(String criteria, String search);

    Book getById(String id);

    Boolean update(Book book);
}
