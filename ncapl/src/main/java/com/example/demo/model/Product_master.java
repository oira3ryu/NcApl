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
	@Column(name = "pmid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pmid;

	private Integer pnid;

	private String cementadjv;

	private String sandadjv;

	private String stoneadjv;

	private String spprice;

	private String stdprice;

	private String startdate;

	private String enddate;

	private Integer flgid;

	private Timestamp createat;

}