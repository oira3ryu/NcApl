package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flg;
import com.example.demo.repository.FlgRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class FlgService {

	@Autowired
	FlgRepository repository;

	public List<Flg> findAll() {
		return repository.findAll();
	}

	public Flg findOne(Integer id) {
		Optional<Flg> flg = repository.findById(id);
		if (flg.isPresent()) {
			return flg.get();
		} else {
			return null;
		}
	}

	public Flg save(Flg flg) {
		return repository.save(flg);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
