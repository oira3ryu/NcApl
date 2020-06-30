package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Unit;
@Repository
	public interface UnitRepository extends JpaRepository<Unit, Integer> {}