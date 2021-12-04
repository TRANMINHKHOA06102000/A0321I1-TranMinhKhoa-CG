package com.codegym.bookloanapp.service.impl;

import com.codegym.bookloanapp.service.CardService;
import com.codegym.bookloanapp.model.Card;
import com.codegym.bookloanapp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findByid(Integer id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void delete(Integer id) {
        cardRepository.deleteById(id);
    }
}
