package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByAuthor(String authorSearch);

    @Query(value = "SELECT * FROM blog where author like :authorSearch", nativeQuery = true)
    List<Blog> searchByAuthor(@Param("authorSearch") String authorSearch);


}
