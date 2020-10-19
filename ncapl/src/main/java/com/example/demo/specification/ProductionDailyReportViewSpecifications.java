package com.example.demo.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Production_daily_report_view;
public class ProductionDailyReportViewSpecifications {

	private ProductionDailyReportViewSpecifications() {

	}

    /**
     * 施工者idが一致するデータを検索
     */
    public static Specification<Production_daily_report_view> coidEqual(Integer coid) {

    	if (coid == null) {
    		return null;
    	}

        return new Specification<Production_daily_report_view>() {
            @Override
            public Predicate toPredicate(Root<Production_daily_report_view> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("coid"), coid);
            }
        };
    }

    /**
     * 現場名idが一致するデータを検索
     */
    public static Specification<Production_daily_report_view> fiidEqual(Integer fiid) {

    	if (fiid == null) {
    		return null;
    	}

        return new Specification<Production_daily_report_view>() {
            @Override
            public Predicate toPredicate(Root<Production_daily_report_view> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("fiid"), fiid);
            }
        };
    }

    /**
     * 記録日が開始日以降のデータを検索
     */
    public static Specification<Production_daily_report_view> recorddateStart(String startDate) {

    	if (StringUtils.isBlank(startDate)) {
    		return null;
    	}

        return new Specification<Production_daily_report_view>() {
            @Override
            public Predicate toPredicate(Root<Production_daily_report_view> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	return cb.greaterThanOrEqualTo(root.get("recorddate"), startDate);
            }
        };
    }

    /**
     * 記録日が開始日以前のデータを検索
     */
    public static Specification<Production_daily_report_view> recorddateEnd(String endDate) {

    	if (StringUtils.isBlank(endDate)) {
    		return null;
    	}

        return new Specification<Production_daily_report_view>() {
            @Override
            public Predicate toPredicate(Root<Production_daily_report_view> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThanOrEqualTo(root.get("recorddate"), endDate);
            }
        };
    }
}
