package com.codegym.service;

import com.codegym.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
