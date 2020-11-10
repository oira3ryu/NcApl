package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pump;
import com.example.demo.repository.PumpRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class PumpService {

	@Autowired
	PumpRepository repository;

	public List<Pump> findAll() {
		return repository.findAll();
	}

	public Pump findOne(Integer id) {
		Optional<Pump> pump = repository.findById(id);
		if (pump.isPresent()) {
			return pump.get();
		} else {
			return null;
		}
	}

	public Pump save(Pump pump) {
		return repository.save(pump);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
