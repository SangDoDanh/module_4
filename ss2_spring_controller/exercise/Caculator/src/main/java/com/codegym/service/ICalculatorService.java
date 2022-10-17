package com.codegym.service;

public interface ICalculatorService {
    double addition(String number1, String number2);

    double subtraction(String number1, String number2);

    double multiplication(String number1, String number2);

    double division(String number1, String number2);
    int check(String number1, String number2);

    String calculartion(String number1, String number2, String operator);
}
