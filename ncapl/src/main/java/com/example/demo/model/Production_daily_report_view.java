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

	private String company;

	private String field;

	private String strength;

	private String aggregate;

	private String slump;

	private String quantity;

	private String record_date;

	private String plant;
}