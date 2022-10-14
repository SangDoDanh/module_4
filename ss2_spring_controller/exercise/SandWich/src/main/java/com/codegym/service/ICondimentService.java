package com.codegym.service;

import com.codegym.model.Condiment;

import java.util.List;
import java.util.Map;

public interface ICondimentService {
    List<Condiment> findAll();

    Map<Integer, Condiment> findAllMap();
}
