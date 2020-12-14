package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tax;
@Repository
	public interface TaxRepository extends JpaRepository<Tax, Integer> {}