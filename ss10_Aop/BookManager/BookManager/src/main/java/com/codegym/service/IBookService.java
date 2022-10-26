package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void oder(int id);

    Book getBook(int id);

    void give(int id);
}
