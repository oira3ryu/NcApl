package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Unit;
import com.example.demo.repository.UnitRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class UnitService {

	@Autowired
	UnitRepository repository;

	public List<Unit> findAll() {
		return repository.findAll();
	}

	public Unit findOne(Integer id) {
		Optional<Unit> unit = repository.findById(id);
		if (unit.isPresent()) {
			return unit.get();
		} else {
			return null;
		}
	}

	public Unit save(Unit unit) {
		return repository.save(unit);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
