package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_production_daily_report_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Production_daily_report_view {
	@Id
	@Column(name = "pdrid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdrid;

	private Integer pnid;

	private Integer coid;

	private String company;

	private Integer fiid;

	private String field;

	private String productname;

	private String quantity;

	private Integer stdprice;

	private Integer spprice;

	private String stdsalesamount;

	private String spsalesamount;

	private String startdate;

	private String recorddate;

	private Integer pid;

	private String plant;
}