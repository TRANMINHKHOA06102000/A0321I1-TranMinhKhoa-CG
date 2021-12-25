package com.codegym.repository.employee;

import com.codegym.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
