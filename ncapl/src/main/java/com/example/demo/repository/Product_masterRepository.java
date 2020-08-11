package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_master;
@Repository
	public interface Product_masterRepository extends JpaRepository<Product_master, Integer> {
	
	}