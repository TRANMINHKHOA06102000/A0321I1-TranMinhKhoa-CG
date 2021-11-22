package com.codegym.repository;


import com.codegym.model.Comment;

import java.util.List;

public interface CommentRepo {
    List<Comment> findAll();
}
