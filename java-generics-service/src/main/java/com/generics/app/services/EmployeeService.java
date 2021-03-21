package com.generics.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.generics.app.dto.EmployeeDTO;
import com.generics.app.entities.Employee;
import com.generics.app.repositories.EmployeeRepository;

import impls.GenericService;

@Service
public class EmployeeService implements GenericService<Employee, EmployeeDTO, Long> {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public JpaRepository<Employee, Long> getRepository() {
		return employeeRepository;
	}

}