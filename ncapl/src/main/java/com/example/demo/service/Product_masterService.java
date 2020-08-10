package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product_master;
import com.example.demo.repository.Product_masterRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Product_masterService {

	@Autowired
	Product_masterRepository repository;

	public List<Product_master> findAll(Sort sort) {
		return repository.findAll();
	}

	public Product_master findOne(Integer id) {
		Optional<Product_master> product_master = repository.findById(id);
		if (product_master.isPresent()) {
			return product_master.get();
		} else {
			return null;
		}
	}

	public Product_master save(Product_master product_master) {
		return repository.save(product_master);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
