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


    @Override
    public int check(String number1, String number2) {
        String regexNumber = "^[\\d]*[\\.]{0,1}[\\d]*$";
        if(!number1.matches(regexNumber) || !number2.matches(regexNumber)) {
            return -1;
        } else if(number2.equals("0")){
            return 0;
        }
        return  1;
    }
}
