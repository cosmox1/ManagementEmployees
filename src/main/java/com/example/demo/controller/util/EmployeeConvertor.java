package com.example.demo.controller.util;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeConvertor {
    public static Employee convertToEmployee(EmployeeDto employeeDto){
        Employee newEmployee= new Employee();
        newEmployee.setEmail(employeeDto.getEmail());
        newEmployee.setEmplyeeCode(employeeDto.getEmplyeeCode());
        newEmployee.setId(employeeDto.getId());
        newEmployee.setImageUrl(employeeDto.getImageUrl());
        newEmployee.setName(employeeDto.getName());
        newEmployee.setPhone(employeeDto.getPhone());
        newEmployee.setJobTitle(employeeDto.getJobTitle());
        return  newEmployee;
    }

    public static EmployeeDto converTOemployeeDto(Employee employee){
        EmployeeDto newEmployeeDto= new EmployeeDto();
        newEmployeeDto.setEmail(employee.getEmail());
        newEmployeeDto.setEmplyeeCode(employee.getEmplyeeCode());
        newEmployeeDto.setId(employee.getId());
        newEmployeeDto.setImageUrl(employee.getImageUrl());
        newEmployeeDto.setName(employee.getName());
        newEmployeeDto.setPhone(employee.getPhone());
        newEmployeeDto.setJobTitle(employee.getJobTitle());
        return newEmployeeDto;
    }

    public static List<EmployeeDto> convertToEmployeeDtoList(List<Employee> employeeList){
        return employeeList.stream().map(employee -> converTOemployeeDto(employee)).collect(Collectors.toList());
    }
}
