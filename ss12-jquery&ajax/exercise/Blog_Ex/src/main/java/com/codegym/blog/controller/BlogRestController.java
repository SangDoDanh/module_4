package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    /**
     * show list blog, use pageable
     *
     * @return
     */
    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAllCategory(@PageableDefault(value = 1) Pageable pageable) {
        Page<Blog> pageList = blogService.findAll(pageable);
        if (pageList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (pageable.getPageNumber() > pageList.getTotalPages()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pageList.getContent(), HttpStatus.OK);
    }

    /**
     * get blog detail
     *
     * @param id
     * @return ResponseEntity<Blog>;
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
     * search blog by author name
     *
     * @param search
     * @return ResponseEntity<List < Blog>>
     */
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogByAuthor(@RequestParam(value = "authorSearch") String search) {
        List<Blog> blogList;
        if ("".equals(search)) {
            blogList = blogService.findAll();
        } else {
            blogList = blogService.searchByName(search);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

}
