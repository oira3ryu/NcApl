package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_sales;
@Repository
	public interface Product_salesRepository extends JpaRepository<Product_sales, Integer> {}