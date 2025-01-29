package com.bakheet.mvc.controller;


import com.bakheet.mvc.domain.Employee;
import com.bakheet.mvc.service.EmployeeServcie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServcie employeeServcie;

    @GetMapping("")
    public String listEmployees(Model employeesModel) {
        List<Employee> employeeList = employeeServcie.findAll();
        Employee newEmployee = new Employee();
        employeesModel.addAttribute("employeeList", employeeList);
        employeesModel.addAttribute("newEmployee", newEmployee);

        return "employees";
    }

    @PostMapping("/updateEmployeeForm")
    public String updateForm(@RequestParam("employeeId")long employeeId, Model employeesModel) {
        Employee updateEmployee = employeeServcie.findById(employeeId);
//        System.out.println(updateEmployee);
        employeesModel.addAttribute("updateEmployee", updateEmployee);
//        System.out.println(updateEmployee.toString());
        return "employeesUpdateForm";
    }

    @PostMapping("/save")
    public String employeeForm(@ModelAttribute("employee") Employee employee) {
        employeeServcie.save(employee);
        return "redirect:/employees";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployeeForm(@RequestParam("employeeId")long employeeId) {
        employeeServcie.deleteById(employeeId);
        return "redirect:/employees";
    }
}
