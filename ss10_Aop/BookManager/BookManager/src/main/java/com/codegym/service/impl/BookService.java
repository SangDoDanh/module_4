package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.selectAll();
    }

    @Override
    public void oder(int id) {
        bookRepository.oder(id);
    }

    @Override
    public Book getBook(int id) {
        List<Book> bookList = bookRepository.findByTitle(id);
        if(bookList.isEmpty())
            return null;
        return bookList.get(0);
    }

    @Override
    public void give(int id) {
        bookRepository.give(id);
    }
}
