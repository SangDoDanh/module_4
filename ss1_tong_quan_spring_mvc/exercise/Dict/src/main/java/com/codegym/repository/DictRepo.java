package com.codegym.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictRepo implements IDictRepo{
    private static Map<String, String> data = new HashMap<>();
    static {
        data.put("dog", "cho");
        data.put("hi", "xin chao");
    }
    @Override
    public String find(String key) {
        if(data.get(key) == null)
            return "Khong tim thay!";
        return data.get(key);
    }
}
