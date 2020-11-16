package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Other_charge;
import com.example.demo.repository.Other_chargeRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Other_chargeService {

	@Autowired
	Other_chargeRepository repository;

	public List<Other_charge> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Other_charge findOne(Integer id) {
		Optional<Other_charge> other_charge = repository.findById(id);
		if (other_charge.isPresent()) {
			return other_charge.get();
		} else {
			return null;
		}
	}

	public Other_charge save(Other_charge other_charge) {
		return repository.save(other_charge);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
