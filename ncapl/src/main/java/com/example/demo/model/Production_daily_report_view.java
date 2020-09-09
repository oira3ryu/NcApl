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
	@Column(name = "pdr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdr_id;

	private Integer pn_id;

	private Integer co_id;

	private String company;

	private Integer fi_id;

	private String field;

	private String product_name;

	private String quantity;

	private Integer std_price;

	private Integer sp_price;

	private String std_sales_amount;

	private String sp_sales_amount;

	private String start_date;

	private String record_date;

	private Integer p_id;

	private String plant;
}