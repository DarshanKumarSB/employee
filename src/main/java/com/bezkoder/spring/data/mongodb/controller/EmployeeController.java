package com.bezkoder.spring.data.mongodb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.model.Employee;
import com.bezkoder.spring.data.mongodb.repository.EmployeeRepository;
import com.bezkoder.spring.mongodb.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  EmployeeRepository tutorialRepository;

 

  @PostMapping("/tutorials")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee tutorial) {
    try {
      Employee _tutorial = tutorialRepository.save(tutorial);
      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Employee> getEmployeeById(String id)
    {
    	Optional<Employee> employeeData = tutorialRepository.findById(id);
    	
    	if(employeeData.isPresent()) {
    	return new ResponseEntity<> (employeeData.get(),HttpStatus.OK);
    	} else {
    		throw new ResourceNotFoundException("Record not found with Id: "  +id);
    	}
    }
    
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
    	List<Employee> employees = new ArrayList<>();
    	tutorialRepository.findAll().forEach(employees::add);
    	return new ResponseEntity<>(employees,HttpStatus.OK);
    }
}
