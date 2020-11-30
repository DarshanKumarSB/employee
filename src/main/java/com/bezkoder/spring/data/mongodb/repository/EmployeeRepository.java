package com.bezkoder.spring.data.mongodb.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
  
	  List<Employee> findByName(String name);
}
