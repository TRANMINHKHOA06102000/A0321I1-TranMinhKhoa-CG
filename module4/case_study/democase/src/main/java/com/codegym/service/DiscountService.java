package com.codegym.service;


import com.codegym.model.Discount;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DiscountService {
    List<Discount> findAll();

    List<Discount> findAllByDiscount(int discounts);

    Discount findById(int id);

    Discount save(Discount discount);

    void delete(int id);

    List<Discount> findAllByStartDate(LocalDate date);

    List<Discount> findAllByEndDate(LocalDate date);
}
