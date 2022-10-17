package com.codegym.service;

import com.codegym.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void add(Employee employee);
}
