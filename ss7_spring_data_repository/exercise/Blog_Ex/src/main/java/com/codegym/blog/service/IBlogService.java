package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findOne(Integer id);

    void remove(int id);

    void update(Blog blog);

    List<Blog> searchByName(String authorSearch);

    Page<Blog> findAll(Pageable pageable);
}
