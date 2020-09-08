package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product_name_view;
import com.example.demo.repository.Product_name_viewRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Product_name_viewService {

	@Autowired
	Product_name_viewRepository repository;

	public List<Product_name_view> findAll() {
		return repository.findAll();
	}

	public Product_name_view findOne(Integer id) {
		Optional<Product_name_view> product_name_view = repository.findById(id);
		if (product_name_view.isPresent()) {
			return product_name_view.get();
		} else {
			return null;
		}
	}

	public Product_name_view save(Product_name_view product_name_view) {
		return repository.save(product_name_view);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
