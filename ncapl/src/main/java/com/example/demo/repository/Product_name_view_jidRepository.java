package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_name_view_jid;
@Repository
	public interface Product_name_view_jidRepository extends JpaRepository<Product_name_view_jid, Integer> {
	@Query("select t from Product_name_view_jid t where jid = :jid")
	public List<Product_name_view_jid> findGeValue(@Param("jid") String jid);
}