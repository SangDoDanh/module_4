package com.codegym.repository.customer;

import com.codegym.dto.CustomerUseServiceDTO;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer " +
            "where name like %:nameSearch% " +
            "and email like %:emailSearch% " +
            "and customer_type_id like %:customerTypeSearch% " +
            "and status = false"
            , nativeQuery = true)
    Page<Customer> search(@Param("nameSearch") String nameSearch,
                          @Param("emailSearch") String emailSearch,
                          @Param("customerTypeSearch") String customerTypeSearch,
                          Pageable pageable);

    @Query(value = "select c.* " +
            "from customer c join contract ct on c.id = ct.customer_id " +
            "where c.status = false " +
            "and (DATE (end_day) >= DATE (now()))",
            nativeQuery = true)
    List<Customer> findUseAll();

    @Query(value = "select * from customer where status = false", nativeQuery = true)
    List<Customer> findAllCustomer();

    @Query(value = "select c.name as name, c.email as email,\n" +
            "       c.phone_number as phoneNumber,\n" +
            "       ct.id as contractId, c.id as customerID,\n" +
            "       f.name as facilityName\n" +
            "from customer c\n" +
            "         right join contract ct on c.id = ct.customer_id join facility f on ct.facility_id = f.id\n" +
            "where c.status = false\n" +
            "  and (DATE(end_day) >= DATE(now()))", nativeQuery = true)
    List<CustomerUseServiceDTO> findUseAllDTO();

    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> getAll();
}
