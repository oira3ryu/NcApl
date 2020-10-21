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
@Table(name = "t_product_name_view")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product_name_view {
	@Id
	@Column(name = "pnid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;

	private String journal;

	private String strength;

	private String aggregate;

	private String slump;

	private String name;

	private String startdate;

	private String enddate;

	private String flag;

	private String createat;

}