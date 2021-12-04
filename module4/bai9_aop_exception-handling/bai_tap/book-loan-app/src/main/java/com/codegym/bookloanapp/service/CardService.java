package com.codegym.bookloanapp.service;

import com.codegym.bookloanapp.model.Card;

import java.util.List;

public interface CardService {
    List<Card> findAll();

    Card findByid(Integer id);

    Card save(Card card);

    void delete(Integer id);
}
