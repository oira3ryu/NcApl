package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product_name;
import com.example.demo.repository.Product_nameRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Product_nameService {

	@Autowired
	Product_nameRepository repository;

	public List<Product_name> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "pnid"));
	}

	public Product_name findOne(Integer id) {
		Optional<Product_name> product_name = repository.findById(id);
		if (product_name.isPresent()) {
			return product_name.get();
		} else {
			return null;
		}
	}

	public Product_name save(Product_name product_name) {
		return repository.save(product_name);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
