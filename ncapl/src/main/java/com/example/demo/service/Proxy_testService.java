package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Proxy_test;
import com.example.demo.repository.Proxy_testRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Proxy_testService {

	@Autowired
	Proxy_testRepository repository;

	public List<Proxy_test> findAll() {
		return repository.findAll();
	}

	public Proxy_test findOne(Integer id) {
		Optional<Proxy_test> proxy_test = repository.findById(id);
		if (proxy_test.isPresent()) {
			return proxy_test.get();
		} else {
			return null;
		}
	}

	public Proxy_test save(Proxy_test proxy_test) {
		return repository.save(proxy_test);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
