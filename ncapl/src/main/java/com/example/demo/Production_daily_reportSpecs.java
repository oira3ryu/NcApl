package com.example.demo;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Production_daily_report;

public class Production_daily_reportSpecs {

    private Production_daily_reportSpecs() {
    }

    public static Specification<Production_daily_report> coidEquals(Integer coid) {
        return coid == null ? null : (root, query, builder) ->
                builder.equal(root.get("coid"), coid);
    }

    public static Specification<Production_daily_report> fiidEquals(Integer fiid) {
        return fiid == null ? null : (root, query, builder) ->
                builder.equal(root.get("fiid"), fiid);
    }

    public static Specification<Production_daily_report> recorddateBetween(Integer startDate, Integer endDate) {
        return startDate == null || endDate == null ? null : (root, query, builder) ->
                builder.between(root.get("recorddate"), startDate, endDate);
    }

}
