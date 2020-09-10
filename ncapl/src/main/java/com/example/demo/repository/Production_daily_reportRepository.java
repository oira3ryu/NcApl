package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Production_daily_report;

@Repository
public interface Production_daily_reportRepository
		extends JpaRepository<Production_daily_report, Integer> {

//	public Production_daily_report findByCo_id(Integer co_id);

}