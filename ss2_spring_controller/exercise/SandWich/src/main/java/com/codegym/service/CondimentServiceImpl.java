package com.codegym.service;

import com.codegym.model.Condiment;
import com.codegym.repository.ICondimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CondimentServiceImpl implements ICondimentService{
    @Autowired
    private ICondimentRepository condimentRepository;
    @Override
    public List<Condiment> findAll() {
        return condimentRepository.findAll();
    }

    @Override
    public Map<Integer, Condiment> findAllMap() {
        return condimentRepository.findAllMap();
    }
}
