package com.codegym.service;


import com.codegym.model.Comment;
import com.codegym.repository.CommentRepo;
import com.codegym.repository.CommentRepoImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService{
    CommentRepo commentRepo=new CommentRepoImpl();

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }
}
