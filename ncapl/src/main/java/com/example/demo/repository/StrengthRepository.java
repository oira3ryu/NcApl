package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Strength;
@Repository
	public interface StrengthRepository extends JpaRepository<Strength, Integer> {}