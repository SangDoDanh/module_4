package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{
    @Override
    public String calculator(String usd, String range) {
        if(!check(usd, range)) {
            return "Bạn đang cung cấp số tiền hoặc tỉ lệ chuyển đổi không hợp lệ!";
        }
        return (Double.parseDouble(usd) * Double.parseDouble(range)) + "";
    }

    private boolean check(String usd, String range) {
        String regexNumber = "^[\\d]*[\\.]{0,1}[\\d]*$";
        if(!(usd+"").matches(regexNumber) || !(range+"").matches(regexNumber)) {
            return false;
        } else if(Double.parseDouble(range) <= 0) {
            return false;
        }
        return true;
    }
}
