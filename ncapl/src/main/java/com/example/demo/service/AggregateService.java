package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	    Optional<Aggregate> aggregate = repository.findById(id);
	    if(aggregate.isPresent()) {
	       return aggregate.get();
	    }else {
	       return null;
	    }
	}

	public void save(Aggregate aggregate) {
		repository.save(aggregate);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
