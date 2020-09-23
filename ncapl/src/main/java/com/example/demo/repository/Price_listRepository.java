package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Price_list;
@Repository
	public interface Price_listRepository extends JpaRepository<Price_list, Integer> {}