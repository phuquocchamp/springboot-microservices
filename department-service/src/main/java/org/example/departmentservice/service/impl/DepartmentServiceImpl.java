package org.example.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.example.departmentservice.dto.DepartmentDto;
import org.example.departmentservice.entity.Department;
import org.example.departmentservice.exception.ResourceNotFoundException;
import org.example.departmentservice.repository.DepartmentRepository;
import org.example.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        return modelMapper.map(departmentRepository.save(modelMapper.map(departmentDto, Department.class)), DepartmentDto.class);
    }



    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department retrieveDepartment = departmentRepository.findByDepartmentCode(departmentCode);
        if(retrieveDepartment == null){
            throw new ResourceNotFoundException("NOT FOUND DEPARTMENT WITH DEPARTMENT CODE: " + departmentCode);
        }
        return modelMapper.map(departmentRepository.findByDepartmentCode(departmentCode), DepartmentDto.class);
    }
}
