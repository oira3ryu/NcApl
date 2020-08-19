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
@Table(name = "t_production_daily_report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Production_daily_report {
	@Id
	@Column(name = "pdr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdr_id;

	private Integer co_id;

	private Integer fi_id;

	private Integer st_id;

	private Integer ag_id;

	private Integer sl_id;

	private String quantity;

	private String record_date;
}