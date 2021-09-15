package com.example.demo.controller;

import com.example.demo.controller.util.EmployeeConvertor;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeServices employeeService;

    @Autowired
    public EmployeeController(EmployeeServices employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto responseBody = EmployeeConvertor.converTOemployeeDto(employeeService.createEmployee(EmployeeConvertor.convertToEmployee(employeeDto)));
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> responseBodyList = EmployeeConvertor.convertToEmployeeDtoList(employeeService.getAllEmployees());
        return ResponseEntity.ok(responseBodyList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDto> getOneEmployee(@PathVariable Long id) {
        EmployeeDto responseBody = EmployeeConvertor.converTOemployeeDto(employeeService.getEmployeeById(id));
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        String message = "succes";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity updateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto responseBody = EmployeeConvertor.converTOemployeeDto(
                employeeService.updateEmployee(EmployeeConvertor.convertToEmployee(employeeDto)));
        return ResponseEntity.ok(responseBody);
    }
}
