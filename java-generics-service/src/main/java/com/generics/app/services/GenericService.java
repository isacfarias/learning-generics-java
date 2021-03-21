package com.generics.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.generics.app.dto.EmployeeDTO;
import com.generics.app.entities.Employee;
import com.generics.app.repositories.EmployeeRepository;

import impls.Convertible;

@Service
public class GenericService<T extends Convertible<DTO>, DTO, ID> {

	@Autowired
	private JpaRepository<T, ID> repository;

	public DTO findById(ID id) {
		Optional<T> result = repository.findById(id);
		return result.get().convert();
	}

	public List<DTO> findAll() {
		return repository.findAll()
				                 .stream()
				                 .map(employee -> employee.convert())
				                 .collect(Collectors.toList());
	}
}