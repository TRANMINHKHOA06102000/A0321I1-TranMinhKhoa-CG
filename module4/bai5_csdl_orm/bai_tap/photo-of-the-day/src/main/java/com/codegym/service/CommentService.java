package com.codegym.service;

import com.codegym.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
}
