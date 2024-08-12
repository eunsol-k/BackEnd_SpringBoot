package com.restapi.emp.service.impl;

import com.restapi.emp.entity.Department;
import com.restapi.emp.exception.ResourceNotFoundException;
import com.restapi.emp.repository.DepartmentRepository;
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
}
