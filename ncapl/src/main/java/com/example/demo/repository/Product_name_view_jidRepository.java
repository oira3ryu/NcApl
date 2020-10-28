package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_name_view_jid;
@Repository
	public interface Product_name_view_jidRepository extends JpaRepository<Product_name_view_jid, Integer> {}