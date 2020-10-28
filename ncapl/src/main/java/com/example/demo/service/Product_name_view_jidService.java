package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product_name_view_jid;
import com.example.demo.repository.Product_name_view_jidRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Product_name_view_jidService {

	@Autowired
	Product_name_view_jidRepository repository;

	public List<Product_name_view_jid> findAll() {
		return repository.findAll();
	}

	public Product_name_view_jid findOne(Integer id) {
		Optional<Product_name_view_jid> product_name_view_jid = repository.findById(id);
		if (product_name_view_jid.isPresent()) {
			return product_name_view_jid.get();
		} else {
			return null;
		}
	}

	public Product_name_view_jid save(Product_name_view_jid product_name_view_jid) {
		return repository.save(product_name_view_jid);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
