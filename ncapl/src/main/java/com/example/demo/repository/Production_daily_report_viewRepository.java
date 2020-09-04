package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Production_daily_report_view;
@Repository
	public interface Production_daily_report_viewRepository extends JpaRepository<Production_daily_report_view, Integer> {}