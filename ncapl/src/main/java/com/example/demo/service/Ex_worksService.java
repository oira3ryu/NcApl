package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ex_works;
import com.example.demo.repository.Ex_worksRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Ex_worksService {

	@Autowired
	Ex_worksRepository repository;

	public List<Ex_works> findAll() {
		return repository.findAll();
	}

	public Ex_works findOne(Integer id) {
		Optional<Ex_works> ex_works = repository.findById(id);
		if (ex_works.isPresent()) {
			return ex_works.get();
		} else {
			return null;
		}
	}

	public Ex_works save(Ex_works ex_works) {
		return repository.save(ex_works);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Ex_works> findByAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
