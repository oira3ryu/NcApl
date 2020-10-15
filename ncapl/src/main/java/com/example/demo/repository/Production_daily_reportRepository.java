package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Production_daily_report;

@Repository
public interface Production_daily_reportRepository
		extends JpaRepository<Production_daily_report, Integer> {
//	@Query("select t from Production_daily_report t where coid >= :coid")
//	public List<Production_daily_report> findGetValue(@Param("coid") Integer coid);
}