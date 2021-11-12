package com.codegym.services.impl;

import com.codegym.services.CaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService{

    @Override
    public double calculate(double number1, double number2, String operator) throws Exception{
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new ArithmeticException("Divide by zero");
                }
        }
        return 0;
    }
}
