package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Slump;
import com.example.demo.repository.SlumpRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class SlumpService {

	@Autowired
	SlumpRepository repository;

	public List<Slump> findAll() {
		return repository.findAll();
	}

	public Slump findOne(Integer id) {
		Optional<Slump> slump = repository.findById(id);
		if (slump.isPresent()) {
			return slump.get();
		} else {
			return null;
		}
	}

	public Slump save(Slump slump) {
		return repository.save(slump);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
