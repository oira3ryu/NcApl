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
@Table(name = "t_product_name_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product_name {
	@Id
	@Column(name = "pn_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pn_id;

	private String strength;

	private String aggregate;

	private String slump;

	private String name;

	private String start_date;

	private String end_date;

	private Integer flg_id;

	private Timestamp create_at;

}