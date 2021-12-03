package com.codegym.exceptionhandlercustomermanage.service;
import com.codegym.exceptionhandlercustomermanage.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
