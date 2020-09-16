package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Field;
import com.example.demo.repository.FieldRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class FieldService {

	@Autowired
	FieldRepository repository;

	public List<Field> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Field findOne(Integer id) {
		Optional<Field> field = repository.findById(id);
		if (field.isPresent()) {
			return field.get();
		} else {
			return null;
		}
	}

	public Field save(Field field) {
		return repository.save(field);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
