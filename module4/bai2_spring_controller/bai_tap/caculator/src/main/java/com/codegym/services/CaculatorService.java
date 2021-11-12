package com.codegym.services;

import org.springframework.stereotype.Service;

@Service
public interface CaculatorService {
    double calculate(double number1, double number2, String operator) throws Exception;
}
