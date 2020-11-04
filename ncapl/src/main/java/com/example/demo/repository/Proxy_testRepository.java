package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Proxy_test;
@Repository
	public interface Proxy_testRepository extends JpaRepository<Proxy_test, Integer> {}