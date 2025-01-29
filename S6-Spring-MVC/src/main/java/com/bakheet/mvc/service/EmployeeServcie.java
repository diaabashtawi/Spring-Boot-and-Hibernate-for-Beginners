package com.bakheet.mvc.service;

import com.bakheet.mvc.domain.Employee;

import java.util.List;

public interface EmployeeServcie {

    List<Employee> findAll();
    Employee findById(long id);
    Employee save(Employee employee);
    void deleteById(long id);
}
