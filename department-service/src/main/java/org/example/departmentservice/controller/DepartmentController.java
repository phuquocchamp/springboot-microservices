package org.example.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.example.departmentservice.dto.DepartmentDto;
import org.example.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("departmentCode") String departmentCode){
        return new ResponseEntity<>(departmentService.getDepartment(departmentCode), HttpStatus.OK);
    }
}
