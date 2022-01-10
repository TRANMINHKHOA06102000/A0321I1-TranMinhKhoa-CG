package com.codegym.repository;

import com.codegym.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
//    @Query("SELECT e FROM Discount e WHERE e.title LIKE ?1 OR e.discounts = ?2")
//    List<Discount> findAllByTitleContainingOrDiscountsContaining(int discount, String name);

    List<Discount> findAllByDiscounts(int search);

    List<Discount> findAllByStartDate(LocalDate date);

    List<Discount> findAllByEndDate(LocalDate date);
}
