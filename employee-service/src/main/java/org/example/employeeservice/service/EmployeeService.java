package org.example.employeeservice.service;

import org.example.employeeservice.dto.APIResponseDto;
import org.example.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
