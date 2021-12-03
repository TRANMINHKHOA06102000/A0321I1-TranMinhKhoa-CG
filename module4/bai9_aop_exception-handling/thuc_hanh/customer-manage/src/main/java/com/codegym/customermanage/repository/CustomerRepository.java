package com.codegym.customermanage.repository;


import com.codegym.customermanage.model.Customer;
import com.codegym.customermanage.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
