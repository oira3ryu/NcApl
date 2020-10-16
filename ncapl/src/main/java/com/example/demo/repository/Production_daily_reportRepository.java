package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Production_daily_report;

@Repository
public interface Production_daily_reportRepository
extends JpaRepository<Production_daily_report, Integer> {
//		extends JpaRepository<Production_daily_report, Integer>, JpaSpecificationExecutor<Production_daily_report> {
//	public class Production_daily_reportSpecifications {
//		public static Specification<Production_daily_report> fiidIn(final String fiids) {
//			return StringUtils.isEmpty(String.valueOf(fiids)) ? null : new Specification<Production_daily_report>() {
//				@Override
//				public Predicate toPredicate(Root<Production_daily_report> root, CriteriaQuery<?> query,
//						CriteriaBuilder cb) {
//					return cb.in(root.get("fiid")).value(fiids);
//				}
//			};
//		}
//
//		public static Specification<Production_daily_report> coidIn(final String coids) {
//			return StringUtils.isEmpty(String.valueOf(coids)) ? null : new Specification<Production_daily_report>() {
//				@Override
//				public Predicate toPredicate(Root<Production_daily_report> root, CriteriaQuery<?> query,
//						CriteriaBuilder cb) {
//					return cb.in(root.get("coid")).value(coids);
//				}
//			};
//		}
//	}

}