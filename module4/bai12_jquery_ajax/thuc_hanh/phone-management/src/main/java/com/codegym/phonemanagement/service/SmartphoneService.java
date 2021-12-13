package com.codegym.phonemanagement.service;

import com.codegym.phonemanagement.model.SmartPhone;

public interface SmartphoneService {
    Iterable<SmartPhone> findAll();

    SmartPhone findById(Integer id);

    SmartPhone save(SmartPhone smartPhone);

    SmartPhone remove(Integer id);
}
