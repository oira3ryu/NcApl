package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Plant;
import com.example.demo.repository.PlantRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class PlantService {

	@Autowired
	PlantRepository repository;

	public List<Plant> findAll() {
		return repository.findAll();
	}

	public Plant findOne(Integer id) {
		Optional<Plant> plant = repository.findById(id);
		if (plant.isPresent()) {
			return plant.get();
		} else {
			return null;
		}
	}

	public Plant save(Plant plant) {
		return repository.save(plant);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
