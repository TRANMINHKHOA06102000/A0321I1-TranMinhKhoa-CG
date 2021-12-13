package com.codegym.phonemanagement.service;

import com.codegym.phonemanagement.model.SmartPhone;
import com.codegym.phonemanagement.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartPhone= findById(id);
        smartphoneRepository.deleteById(id);
        return smartPhone;
    }
}
