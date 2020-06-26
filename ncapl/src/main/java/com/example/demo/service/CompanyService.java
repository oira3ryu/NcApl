package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class CompanyService {

	@Autowired
	CompanyRepository repository;

	public List<Company> findAll() {
		return repository.findAll();
	}

	public Company findOne(Integer id) {
		Optional<Company> company = repository.findById(id);
		if (company.isPresent()) {
			return company.get();
		} else {
			return null;
		}
	}

	public Company save(Company company) {
		return repository.save(company);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
