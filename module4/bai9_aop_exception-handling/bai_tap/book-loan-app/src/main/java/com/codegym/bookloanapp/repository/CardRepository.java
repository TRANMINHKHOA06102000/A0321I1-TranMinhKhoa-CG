package com.codegym.bookloanapp.repository;

import com.codegym.bookloanapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
