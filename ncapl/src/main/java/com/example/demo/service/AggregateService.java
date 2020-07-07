package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Aggregate;
import com.example.demo.repository.AggregateRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class AggregateService {

	@Autowired
	private AggregateRepository repository;

	public List<Aggregate> findAll() {
		return repository.findAll();
	}

	public Aggregate findOne(Integer id) {
		return repository.findOne(id);
	}

	public Aggregate save(Aggregate aggregate) {
		return repository.save(aggregate);
	}

	public void delete(Integer id) {
		repository.delete(id);
	}
}
