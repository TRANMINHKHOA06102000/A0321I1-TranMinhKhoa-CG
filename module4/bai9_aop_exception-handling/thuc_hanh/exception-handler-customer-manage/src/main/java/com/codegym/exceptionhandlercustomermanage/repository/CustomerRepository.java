package com.codegym.exceptionhandlercustomermanage.repository;

import com.codegym.exceptionhandlercustomermanage.model.Customer;
import com.codegym.exceptionhandlercustomermanage.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
