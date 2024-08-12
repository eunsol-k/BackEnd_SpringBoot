package com.restapi.emp.controller;

import com.restapi.emp.dto.EmployeeDto;
import com.restapi.emp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API
    // @Valid 요건을 충족하지 않으면 Errors로 에러 정보를 받음
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
//        if (errors.hasErrors()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getAllErrors());
//        }
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesDepartment() {
        return ResponseEntity.ok(employeeService.getAllEmployeesDepartment());
    }


    // Build Update Employee REST API
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
          EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
          return ResponseEntity.ok(employeeDto);
    }

    // Build Delete Employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
