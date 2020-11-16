package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Extra_charge;
@Repository
	public interface Extra_chargeRepository extends JpaRepository<Extra_charge, Integer> {}