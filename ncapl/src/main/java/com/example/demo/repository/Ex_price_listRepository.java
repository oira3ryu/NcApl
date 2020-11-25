package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ex_price_list;
@Repository
	public interface Ex_price_listRepository extends JpaRepository<Ex_price_list, Integer> {}