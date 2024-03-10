package org.example.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.example.employeeservice.dto.APIResponseDto;
import org.example.employeeservice.dto.DepartmentDto;
import org.example.employeeservice.dto.EmployeeDto;
import org.example.employeeservice.entity.Employee;
import org.example.employeeservice.exception.ResourceNotFoundException;
import org.example.employeeservice.repository.EmployeeRepository;
import org.example.employeeservice.service.APIClient;
import org.example.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private WebClient webClient;
    private APIClient apiClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto, Employee.class)), EmployeeDto.class);
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee retrieveEmployee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("NOT FOUND EMPLOYEE WITH ID: " + employeeId)
        );

        DepartmentDto departmentDto = apiClient.getDepartment(retrieveEmployee.getDepartmentCode());


        return new APIResponseDto(modelMapper.map(retrieveEmployee, EmployeeDto.class), departmentDto);
    }
}
