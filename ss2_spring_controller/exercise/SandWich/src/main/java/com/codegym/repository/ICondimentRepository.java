package com.codegym.repository;

import com.codegym.model.Condiment;

import java.util.List;
import java.util.Map;

public interface ICondimentRepository {
    List<Condiment> findAll();

    Map<Integer, Condiment> findAllMap();
}
