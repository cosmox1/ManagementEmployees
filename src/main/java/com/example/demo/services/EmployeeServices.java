package com.example.demo.services;

import com.example.demo.model.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServices(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee createEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new IllegalArgumentException("does not exist");
        }
        Employee employeeToBeDeleted = employeeOptional.get();
        employeeRepo.delete(employeeToBeDeleted);
        return employeeToBeDeleted;
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new IllegalArgumentException("no such employee");
        }
        return employeeOptional.get();
    }

    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employee.getId());
        if (!optionalEmployee.isPresent()) {
            throw new IllegalArgumentException("no such employee to update");
        }
        Employee persistedEmployee = optionalEmployee.get();
        persistedEmployee.setEmail(employee.getEmail());
        persistedEmployee.setEmplyeeCode(employee.getEmplyeeCode());
        persistedEmployee.setId(employee.getId());
        persistedEmployee.setImageUrl(employee.getImageUrl());
        persistedEmployee.setName(employee.getName());
        persistedEmployee.setPhone(employee.getPhone());
        persistedEmployee.setJobTitle(employee.getJobTitle());
        return persistedEmployee;
    }
}
