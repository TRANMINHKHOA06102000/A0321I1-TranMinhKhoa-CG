package com.codegym.bookloanapp.service;

import com.codegym.bookloanapp.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    void delete(Integer id);

}
