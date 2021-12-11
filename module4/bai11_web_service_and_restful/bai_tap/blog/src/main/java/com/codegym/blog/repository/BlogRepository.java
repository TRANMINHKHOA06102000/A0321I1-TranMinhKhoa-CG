package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    List<Blog> findAll();
    //Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
}
