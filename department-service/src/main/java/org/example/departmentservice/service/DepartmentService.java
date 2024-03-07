package org.example.departmentservice.service;

import org.example.departmentservice.dto.DepartmentDto;
import org.example.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String departmentCode);
}
