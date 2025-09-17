package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; 
import java.util.Optional;

@RestController
@RequestMapping("/api/employees") 
public class EmployeeController{

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List <Employee> getAllEmployees() {
         return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable Long id) { 
        Optional <Employee> employee= employeeService.getEmployeeById(id); 
        return employee.map(ResponseEntity::ok).orElseGet(()->
ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee addEmployee (@RequestBody Employee employee) {
         return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
       Employee updatedEmployee=employeeService.updateEmployee(id, employee); 
       
       if(updatedEmployee != null) {
        return ResponseEntity.ok(updatedEmployee);
         } else {
        return ResponseEntity.notFound().build();
         }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) { 
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}