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
@Table(name = "t_product_name")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product_name {
	@Id
	@Column(name = "pn_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pn_id;

	private Integer j_id;

	private Integer st_id;

	private Integer ag_id;

	private Integer sl_id;

	private String name;

	private String start_date;

	private String end_date;

	private Integer flg_id;

	private Timestamp create_at;

}