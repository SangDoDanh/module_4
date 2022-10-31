package com.codegym.blog.controller;

import com.codegym.blog.dto.BlogDto;
import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    /**
     * Xem danh sách các bài viết
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Blog>> getAllCategory() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    /**
     * Xem chi tiết một bài viết
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
        Blog blog = blogService.findOne(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


    /**
     * Xem danh sách các bài viết của một category
     * @param authorSearch
     * @return
     */
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
