package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRepository implements IEmployeeRepository{
    private  static List<Employee> employeeList;
    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("NV-1", "Nguyen Van A", "HCM-0987654321", new String[]{"java", "php", "c#"}));
        employeeList.add(new Employee("NV-2", "Nguyen Van C", "DN-0987654321", new String[]{"java", "c#"}));
        employeeList.add(new Employee("NV-3", "Nguyen Van B", "HN-0987654321", new String[]{"java", "php"}));
    }
    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        employeeList.add(employee);
    }
}
