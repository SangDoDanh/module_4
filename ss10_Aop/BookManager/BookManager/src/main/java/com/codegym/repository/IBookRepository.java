package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select  * from book where status = 0",nativeQuery = true)
    List<Book> selectAll();

    @Modifying
    @Transactional
    @Query(value = "update book set status = 1 where id = :id",nativeQuery = true)
    void oder(@Param("id") int id);

    @Query(value = "select * from book where title_id = :id and status = 0", nativeQuery = true)
    List<Book> findByTitle(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update book set status = 0 where id = :id", nativeQuery = true)
    void give(@Param("id") int id);
}
