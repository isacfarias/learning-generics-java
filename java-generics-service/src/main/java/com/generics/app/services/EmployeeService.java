package com.generics.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generics.app.dto.EmployeeDTO;
import com.generics.app.entities.Employee;
import com.generics.app.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO findById(Long id) {
		Optional<Employee> result = employeeRepository.findById(id);
		return new EmployeeDTO(result.get());
	}
}