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

    @Override
    public String calculartion(String number1, String number2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = addition(number1, number2);
                break;
            case "-":
                result = subtraction(number1, number2);
                break;
            case "*":
                result = multiplication(number1, number2);
                break;
            case "/":
                if(check(number1, number2) == 0) {
                    return "Ban dang thuc hien mot phep chia cho 0";
                }
                result = division(number1, number2);
                break;
        }
        return result + "";
    }
}
