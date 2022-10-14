package com.codegym.repository;

import com.codegym.model.Condiment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CondimentRepositoryImpl implements ICondimentRepository{
    private static List<Condiment> data;
    static {
        data = new ArrayList<>();
        data.add(new Condiment(1, "Lettuce"));
        data.add(new Condiment(2, "Tomato"));
        data.add(new Condiment(3, "Mustard"));
        data.add(new Condiment(4, "Sprouts"));
    }
    @Override
    public List<Condiment> findAll() {
        return data;
    }

    @Override
    public Map<Integer, Condiment> findAllMap() {
        Map<Integer, Condiment> result = new HashMap<>();
        for(int i = 0; i < data.size(); i++) {
            result.put(data.get(i).getId(), data.get(i));
        }
        return result;
    }
}
