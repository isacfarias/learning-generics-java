package com.generics.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generics.app.dto.EmployeeDTO;
import com.generics.app.entities.Employee;
import com.generics.app.services.EmployeeService;
import com.generics.app.services.GenericService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private GenericService<Employee, EmployeeDTO, Long> service;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> objs = service.findAll();
		return ResponseEntity.ok(objs);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		EmployeeDTO obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
}