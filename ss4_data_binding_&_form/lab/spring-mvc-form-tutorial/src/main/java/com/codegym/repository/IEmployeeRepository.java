package com.codegym.repository;

import com.codegym.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void add(Employee employee);
}
