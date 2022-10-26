package com.codegym.service;

import com.codegym.model.Title;

import java.util.List;

public interface ITitleService {
    List<Title> findAll();

    Title findTitleById(int id);
}
