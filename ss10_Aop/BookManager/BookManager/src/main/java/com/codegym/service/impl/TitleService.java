package com.codegym.service.impl;

import com.codegym.model.Title;
import com.codegym.repository.ITitleRepository;
import com.codegym.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService implements ITitleService {
    @Autowired
    private ITitleRepository titleRepository;
    @Override
    public List<Title> findAll() {
        return titleRepository.getAll();
    }

    @Override
    public Title findTitleById(int id) {
        return titleRepository.findById(id).get();
    }
}
