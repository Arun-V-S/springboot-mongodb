package com.example.junit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository repository;
	
	@Before
	public void setup() throws Exception
	{
		Employee employee = new Employee();
		employee.setAge(23);
		employee.setName("Sam");
		employee.setEmail("sam@gmail.com");
		assertNull(employee.getId());
	    repository.save(employee);
	    assertNotNull(employee.getId());	
	}
	
	@Test
	public void getData()
	{
        Employee employee = repository.findOneByName("Sam");
        assertNotNull(employee);
        assertEquals(23, repository.findOneByName("Sam").getAge());
	}
	
	@Test
	public void updateData()
	{
		int testage = 24;
		Employee employee = repository.findOneByName("Sam");
        employee.setAge(testage);
        repository.save(employee);
        assertEquals(testage, repository.findOneByName("Sam").getAge());
	}
	
	@After
	public void tearDown() throws Exception
	{
		Employee employee = repository.findOneByName("Sam");
		repository.delete(employee);
	}
	
}
