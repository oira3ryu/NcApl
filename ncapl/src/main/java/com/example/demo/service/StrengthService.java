package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Strength;
import com.example.demo.repository.StrengthRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class StrengthService {

	@Autowired
	StrengthRepository repository;

	public List<Strength> findAll() {
		return repository.findAll();
	}

	public Strength findOne(Integer id) {
		Optional<Strength> strength = repository.findById(id);
		if (strength.isPresent()) {
			return strength.get();
		} else {
			return null;
		}
	}

	public Strength save(Strength strength) {
		return repository.save(strength);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
