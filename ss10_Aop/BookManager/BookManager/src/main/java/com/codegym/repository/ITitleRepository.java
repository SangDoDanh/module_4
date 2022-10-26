package com.codegym.repository;

import com.codegym.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITitleRepository extends JpaRepository<Title, Integer> {

    @Query(value = "select  * from title where status = 0", nativeQuery = true)
    List<Title> getAll();
}
