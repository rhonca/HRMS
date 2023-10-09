package com.honca.hrms.controllers;

import com.honca.hrms.models.dto.EmployeeRequest;
import com.honca.hrms.models.dto.EmployeeResponse;
import com.honca.hrms.models.entities.Employee;
import com.honca.hrms.services.interfaces.EmployeeService;
import com.honca.hrms.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest newEmployeeRequest) {
        Employee addedEmployee = employeeService.addEmployee(newEmployeeRequest);
        EmployeeResponse addedEmployeeResponse = EmployeeMapper.INSTANCE.employeeToEmployeeResponse(addedEmployee);
        return new ResponseEntity<>(addedEmployeeResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeRequest updatedEmployeeRequest) {
        Employee savedEmployee = employeeService.updateEmployee(employeeId, updatedEmployeeRequest);
        EmployeeResponse savedEmployeeResponse = EmployeeMapper.INSTANCE.employeeToEmployeeResponse(savedEmployee);
        return new ResponseEntity<>(savedEmployeeResponse, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> foundEmployeeList = employeeService.findAllEmployees();
        List<EmployeeResponse> foundEmployeeResponseList = EmployeeMapper.INSTANCE.EmployeeResponseemployeeToEmployeeResponse(foundEmployeeList);
        return new ResponseEntity<>(foundEmployeeResponseList, HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long employeeId) {
        Employee foundEmployee = employeeService.findEmployeeById(employeeId);
        EmployeeResponse foundEmployeeResponse = EmployeeMapper.INSTANCE.employeeToEmployeeResponse(foundEmployee);
        return new ResponseEntity<>(foundEmployeeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        Employee foundEmployee = employeeService.findEmployeeById(employeeId);
        employeeService.deleteEmployee(foundEmployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
