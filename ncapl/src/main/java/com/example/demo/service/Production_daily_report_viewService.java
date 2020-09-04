package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Production_daily_report_view;
import com.example.demo.repository.Production_daily_report_viewRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Production_daily_report_viewService {

	@Autowired
	Production_daily_report_viewRepository repository;

	public List<Production_daily_report_view> findAll() {
		return repository.findAll();
	}

	public Production_daily_report_view findOne(Integer id) {
		Optional<Production_daily_report_view> production_daily_report_view = repository.findById(id);
		if (production_daily_report_view.isPresent()) {
			return production_daily_report_view.get();
		} else {
			return null;
		}
	}

	public Production_daily_report_view save(Production_daily_report_view production_daily_report_view) {
		return repository.save(production_daily_report_view);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
