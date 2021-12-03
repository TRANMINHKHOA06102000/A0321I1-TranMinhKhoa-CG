package com.codegym.exceptionhandlercustomermanage.service.impl;

import com.codegym.exceptionhandlercustomermanage.model.Province;
import com.codegym.exceptionhandlercustomermanage.repository.ProvinceRepository;
import com.codegym.exceptionhandlercustomermanage.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
