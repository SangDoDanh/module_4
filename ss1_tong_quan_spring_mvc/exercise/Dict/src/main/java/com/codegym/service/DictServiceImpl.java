package com.codegym.service;

import com.codegym.repository.IDictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictServiceImpl implements IDictService{
    @Autowired
    private IDictRepo iDictRepo;
    @Override
    public String dict(String key) {
       return iDictRepo.find(key);
    }
}
