package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer " +
            "where name like %:nameSearch% " +
            "and email like %:emailSearch% " +
            "and customer_type_id like %:customerTypeSearch%"
            ,nativeQuery = true)
    Page<Customer> search(@Param("nameSearch") String nameSearch,
                          @Param("emailSearch") String emailSearch,
                          @Param("customerTypeSearch") String customerTypeSearch,
                          Pageable pageable);
}
