package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
@EnableMongoRepositories(basePackageClasses = EmployeeRepository.class)

public class EmployeeController {

	@Autowired
	EmployeeRepository employeerepository;
	
	//create
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create (@RequestBody Employee employee) {
		employeerepository.save(employee);
	}
	
	//read
	@RequestMapping(value="/{id}")
	public Employee read(@PathVariable String id) {
		return employeerepository.findOne(id);
	}
	
	//update
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Employee employee) {
		employeerepository.save(employee);
	}
	
	//delete
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		employeerepository.delete(id);
	}
}
