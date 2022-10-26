package com.codegym.repository;

import com.codegym.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IOrderBookRepository extends JpaRepository<OrderBook, Integer> {

    @Query(value = "select * from order_book where otp = :otp and status = 0", nativeQuery = true)
    Optional<OrderBook> findOrderBookByOtp(@Param("otp") Integer otp);

    @Modifying
    @Transactional
    @Query(value = "update order_book set status = 1 where it = :id", nativeQuery = true)
    void remove(@Param("id") int id);
}
