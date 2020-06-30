package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Type;
import com.example.demo.repository.TypeRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class TypeService {

	@Autowired
	TypeRepository repository;

	public List<Type> findAll() {
		return repository.findAll();
	}

	public Type findOne(Integer id) {
		Optional<Type> type = repository.findById(id);
		if (type.isPresent()) {
			return type.get();
		} else {
			return null;
		}
	}

	public Type save(Type type) {
		return repository.save(type);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
