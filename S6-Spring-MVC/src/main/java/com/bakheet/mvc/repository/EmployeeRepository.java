package com.bakheet.mvc.repository;

import com.bakheet.mvc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
