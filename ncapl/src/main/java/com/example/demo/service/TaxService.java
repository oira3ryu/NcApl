package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tax;
import com.example.demo.repository.TaxRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class TaxService {

	@Autowired
	TaxRepository repository;

	public List<Tax> findAll() {
		return repository.findAll();
	}

	public Tax findOne(Integer id) {
		Optional<Tax> tax = repository.findById(id);
		if (tax.isPresent()) {
			return tax.get();
		} else {
			return null;
		}
	}

	public Tax save(Tax tax) {
		return repository.save(tax);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
