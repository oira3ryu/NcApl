package com.example.demo.model;

import java.sql.Timestamp;

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
@Table(name = "t_product_master_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product_master {
	@Id
	@Column(name = "pm_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pm_id;

	private Integer pn_id;

	private String cement_adjv;

	private String sand_adjv;

	private String stone_adjv;

	private String sp_price;

	private String std_price;

	private String start_date;

	private String end_date;

	private Integer flg_id;

	private Timestamp create_at;

}