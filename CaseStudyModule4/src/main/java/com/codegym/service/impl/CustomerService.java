package com.codegym.service.impl;

import com.codegym.dto.CustomerUseService;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> search(String nameSearch, String emailSearch, String customerTypeSearch, Pageable pageable) {
        return customerRepository.search(nameSearch, emailSearch, customerTypeSearch, pageable);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public List<Customer> findUseAll() {
        return customerRepository.findUseAll();
    }

    @Override
    public List<CustomerUseService> findUseAllDTO() {
        return customerRepository.findUseAllDTO();
    }
}
