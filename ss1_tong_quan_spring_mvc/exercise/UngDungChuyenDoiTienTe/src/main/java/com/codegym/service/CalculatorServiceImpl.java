package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{
    @Override
    public double calculator(int usd, double range) {
        return usd * range;
    }
}
