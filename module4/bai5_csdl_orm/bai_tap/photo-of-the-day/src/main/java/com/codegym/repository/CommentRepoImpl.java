package com.codegym.repository;


import com.codegym.model.Comment;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CommentRepoImpl implements CommentRepo {
    @Override
    public List<Comment> findAll() {
        Session session = null;
        List commentList = null;
        try {
            String queryStr = "SELECT c FROM Comment AS c";
            session = ConnectionUtil.sessionFactory.openSession();
            commentList = session.createQuery(queryStr).getResultList();
        } finally {
            if (session != null)
                session.close();
        }
        return commentList;
    }
}
