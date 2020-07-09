package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Flg;
@Repository
	public interface FlgRepository extends JpaRepository<Flg, Integer> {}