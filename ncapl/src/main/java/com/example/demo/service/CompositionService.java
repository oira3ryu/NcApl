package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Composition;
import com.example.demo.repository.CompositionRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class CompositionService {

	@Autowired
	CompositionRepository repository;

	public List<Composition> findAll() {
		return repository.findAll();
	}

	public Composition findOne(Integer id) {
		Optional<Composition> composition = repository.findById(id);
		if (composition.isPresent()) {
			return composition.get();
		} else {
			return null;
		}
	}

	public Composition save(Composition composition) {
		return repository.save(composition);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
