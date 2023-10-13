package com.honca.hrms.controllers;

import com.honca.hrms.models.dto.DepartmentRequest;
import com.honca.hrms.models.dto.DepartmentResponse;
import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.entities.Department;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.services.interfaces.DepartmentService;
import com.honca.hrms.services.mappers.DepartmentMapper;
import com.honca.hrms.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<DepartmentResponse> addDepartment(@RequestBody DepartmentRequest newDepartmentRequest) {
        Department addedDepartment = departmentService.createDepartment(newDepartmentRequest);
        DepartmentResponse addedDepartmentResponse = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(addedDepartment);
        return new ResponseEntity<>(addedDepartmentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{departmentId}")
    public ResponseEntity<DepartmentResponse> updateDepartment(@PathVariable Long departmentId, @RequestBody DepartmentRequest updatedDepartmentRequest) {
        Department savedDepartment = departmentService.updateDepartment(departmentId, updatedDepartmentRequest);
        DepartmentResponse savedDepartmentResponse = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(savedDepartment);
        return new ResponseEntity<>(savedDepartmentResponse, HttpStatus.OK);
    }

    @PutMapping("/addEmployee/{departmentId}/{employeeId}")
    public ResponseEntity<DepartmentResponse> addEmployees(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        Department foundDepartment = departmentService.addEmployee(departmentId, employeeId);
        DepartmentResponse foundDepartmentResponse = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(foundDepartment);
        return new ResponseEntity<>(foundDepartmentResponse, HttpStatus.OK); //TO DO make better response besides HTTP code
    }

    @PutMapping("/removeEmployee/{departmentId}/{employeeId}")
    public ResponseEntity<DepartmentResponse> removeEmployee(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        Department foundDepartment = departmentService.removeEmployee(departmentId, employeeId);
        DepartmentResponse foundDepartmentResponse = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(foundDepartment);
        return new ResponseEntity<>(foundDepartmentResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        List<Department> foundDepartmentList = departmentService.findAllDepartments();
        List<DepartmentResponse> foundDepartmentResponseList = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(foundDepartmentList);
        return new ResponseEntity<>(foundDepartmentResponseList, HttpStatus.OK);
    }

    @GetMapping("/get/{departmentId}")
    public ResponseEntity<DepartmentResponse> getDepartment(@PathVariable Long departmentId) {
        Department foundDepartment = departmentService.findDepartmentById(departmentId);
        DepartmentResponse foundDepartmentResponse = DepartmentMapper.INSTANCE.departmentToDepartmentResponse(foundDepartment);
        return new ResponseEntity<>(foundDepartmentResponse, HttpStatus.OK);
    }

    @GetMapping("/getEmployees/{departmentId}")
    public ResponseEntity<List<EmployeeResponse>> getEmployees(@PathVariable Long departmentId) {
        List<Employee> foundEmployeeList = departmentService.findAllEmployees(departmentId);
        List<EmployeeResponse> foundEmployeeResponseList = EmployeeMapper.INSTANCE.EmployeeResponseemployeeToEmployeeResponse(foundEmployeeList);
        return new ResponseEntity<>(foundEmployeeResponseList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId) {
        Department foundDepartment = departmentService.findDepartmentById(departmentId);
        departmentService.deleteDepartment(foundDepartment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
