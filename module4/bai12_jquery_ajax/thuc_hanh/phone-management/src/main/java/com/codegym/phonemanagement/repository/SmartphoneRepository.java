package com.codegym.phonemanagement.repository;

import com.codegym.phonemanagement.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<SmartPhone,Integer> {
}
