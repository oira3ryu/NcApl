package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product_master;
@Repository
	public interface Product_masterRepository extends JpaRepository<Product_master, Integer> {
	@Query(value = "SELECT t1.pm_id,"
			+ "t2.pn_id,"
			+ "t2.name,"
			+ "t1.st_id,"
			+ "t1.ag_id,"
			+ "t1.sl_id,"
			+ "t1.cement_adjv,"
			+ "t1.sand_adjv,"
			+ "t1.stone_adjv,"
			+ "t1.sp_price,"
			+ "t1.std_price,"
			+ "t1.start_date,"
			+ "t1.end_date,"
			+ "t1.create_at,"
			+ "t1.flg_id,"
			+ "t3.value"
			+ " FROM t_product_master t1"
			+ " JOIN t_product_name t2 ON t1.pn_id = t2.pn_id"
			+ " JOIN t_flg t3 ON t1.flg_id = t3.id"
			+ " ORDER BY t1.pm_id",
			nativeQuery = true)
	List<Product_master> product_master();

}