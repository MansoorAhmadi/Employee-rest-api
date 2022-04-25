package com.example.employeerestapi.controller;

import com.example.employeerestapi.model.Employee;
import com.example.employeerestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    //HTTP get method
    @GetMapping
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    //HTTP create method
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    //findById
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found" + id ));
        return ResponseEntity.ok(employee);
    }

    //HTTP update method
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));

        //we get the details in parameter and set into the employee object
        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());
        employee.setEmail(employeeDetails.getEmail());

        //we use the repository to save the new information
        repository.save(employee);

        //we return with a response entity
        return ResponseEntity.ok(employee);
    }

    //delete method
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));

        repository.delete(employee);

        //we are not returning anything
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
