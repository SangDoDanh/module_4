package com.codegym.blog.controller;

import com.codegym.blog.dto.BlogDto;
import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAllCategory() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BlogDto>> getAllBlogByBlogId(@RequestParam String authorSearch) {
        List<Blog> blogList;
        BlogDto blogDto;
        List<BlogDto> blogDtoList = new ArrayList<>();
        if ("".equals(authorSearch)) {
            blogList = blogService.findAll();
        } else {
            blogList = blogService.searchByName("%" + authorSearch + "%");
        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for (Blog blog : blogList) {
            blogDto = new BlogDto();
            BeanUtils.copyProperties(blog, blogDto);
            blogDto.setCategoryID(blog.getCategory().getId());
            blogDtoList.add(blogDto);
        }
        return new ResponseEntity<>(blogDtoList, HttpStatus.OK);
    }
}
