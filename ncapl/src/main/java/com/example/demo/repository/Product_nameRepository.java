package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_name;
@Repository
	public interface Product_nameRepository extends JpaRepository<Product_name, Integer> {}