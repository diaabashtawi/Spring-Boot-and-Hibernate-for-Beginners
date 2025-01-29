package com.bakheet.mvc.service;

import com.bakheet.mvc.domain.Employee;
import com.bakheet.mvc.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeServcie{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee emp = null;
        if (employee.isPresent()) {
            emp = employee.get();
        }else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return emp;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
