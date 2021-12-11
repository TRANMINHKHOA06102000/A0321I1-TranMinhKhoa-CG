package com.codegym.blog.service;


import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    //Iterable<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    //Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
}
