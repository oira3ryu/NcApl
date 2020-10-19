package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.form.DailyreportSearchForm;
import com.example.demo.model.Production_daily_report;
import com.example.demo.repository.Production_daily_reportRepository;
import com.example.demo.specification.ProductionDailyReportSpecifications;

@Service
@Transactional(rollbackOn=Exception.class)
public class Production_daily_reportService {

	@Autowired
	Production_daily_reportRepository repository;

	@PersistenceContext
	private EntityManager em;

	public List<Production_daily_report> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "pdrid"));
	}

	public List<Production_daily_report> findByForm(DailyreportSearchForm searchParam) {

        if (searchParam == null) {
            return findAll();
        }

        return repository.findAll(Specification
    			.where(ProductionDailyReportSpecifications.coidEqual(searchParam.getCoid()))
        		.and(ProductionDailyReportSpecifications.fiidEqual(searchParam.getFiid()))
        		.and(ProductionDailyReportSpecifications.recorddateStart(searchParam.getRecorddate()))
        		.and(ProductionDailyReportSpecifications.recorddateEnd(searchParam.getRecorddateEnd()))
        		, Sort.by(Sort.Direction.ASC, "pdrid"));
    }

	public Production_daily_report findOne(Integer id) {
		Optional<Production_daily_report> production_daily_report = repository.findById(id);
		if (production_daily_report.isPresent()) {
			return production_daily_report.get();
		} else {
			return null;
		}
	}

	public Production_daily_report save(Production_daily_report production_daily_report) {
		return repository.save(production_daily_report);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
