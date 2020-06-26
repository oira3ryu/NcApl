package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Field;
@Repository
	public interface FieldRepository extends JpaRepository<Field, Integer> {}