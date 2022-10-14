package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{
    @Override
    public double addition(String number1, String number2) {
        return Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    @Override
    public double subtraction(String number1, String number2) {
        return Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    @Override
    public double multiplication(String number1, String number2) {
        return Double.parseDouble(number1) * Double.parseDouble(number2);
    }

    @Override
    public double division(String number1, String number2) {
        return Double.parseDouble(number1) / Double.parseDouble(number2);
    }
}
