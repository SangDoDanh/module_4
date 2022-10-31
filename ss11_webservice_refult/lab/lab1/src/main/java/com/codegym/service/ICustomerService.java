package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(int id);

    void save(Customer customer);

    void deleteById(int id);
}
