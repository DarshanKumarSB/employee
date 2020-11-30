package com.bezkoder.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
  @Id
  private String id;

  private String name;
  
  private String salary;
  
  

public Employee() {
}


public Employee(String name, String salary) {
	this.name = name;
	this.salary = salary;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSalary() {
	return salary;
}


public void setSalary(String salary) {
	this.salary = salary;
}
  

  
}
