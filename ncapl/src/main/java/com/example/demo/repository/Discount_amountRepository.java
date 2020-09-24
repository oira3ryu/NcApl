package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Discount_amount;
@Repository
	public interface Discount_amountRepository extends JpaRepository<Discount_amount, Integer> {}