package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product_sales;
import com.example.demo.repository.Product_salesRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Product_salesService {

	@Autowired
	Product_salesRepository repository;

	public List<Product_sales> findAll() {
		return repository.findAll();
	}

	public Product_sales findOne(Integer id) {
		Optional<Product_sales> product_sales = repository.findById(id);
		if (product_sales.isPresent()) {
			return product_sales.get();
		} else {
			return null;
		}
	}

	public Product_sales save(Product_sales product_sales) {
		return repository.save(product_sales);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
