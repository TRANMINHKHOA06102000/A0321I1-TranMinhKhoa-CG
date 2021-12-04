package com.codegym.bookloanapp.repository;

import com.codegym.bookloanapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
