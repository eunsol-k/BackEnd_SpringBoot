package com.restapi.emp.service.impl;

import com.restapi.emp.entity.Department;
import com.restapi.emp.entity.Employee;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.DepartmentRepository;
import com.restapi.emp.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;

public class Common {
    public static Department getDepartment(Long departmentId, DepartmentRepository departmentRepository) {
        String errMsg = String.format("Department is not exists with a given id: %s", departmentId);
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(errMsg, HttpStatus.NOT_FOUND)
                );
        return department;
    }

    public static Employee getEmployee(Long employeeId, EmployeeRepository employeeRepository) {
        String errMsg = String.format("Employee is not exists with a given id: %s", employeeId);
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(errMsg, HttpStatus.NOT_FOUND));
        return employee;
    }
}
