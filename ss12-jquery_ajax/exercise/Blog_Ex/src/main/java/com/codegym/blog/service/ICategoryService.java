package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import java.util.*;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void delete(int id);
}
