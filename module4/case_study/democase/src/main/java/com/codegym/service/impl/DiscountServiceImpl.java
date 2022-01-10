package com.codegym.service.impl;

import com.codegym.model.Discount;
import com.codegym.repository.DiscountRepository;
import com.codegym.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public List<Discount> findAllByDiscount(int discounts) {
        return discountRepository.findAllByDiscounts(discounts);
    }

    @Override
    public Discount findById(int id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public void delete(int id) {
        discountRepository.deleteById(id);
    }

    @Override
    public List<Discount> findAllByStartDate(LocalDate date) {
        return discountRepository.findAllByStartDate(date);
    }

    @Override
    public List<Discount> findAllByEndDate(LocalDate date) {
        return discountRepository.findAllByEndDate(date);
    }

}
