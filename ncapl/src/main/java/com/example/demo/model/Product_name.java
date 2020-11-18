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
	@Column(name = "pnid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;

	private Integer jid;

	private Integer stid;

	private Integer agid;

	private Integer slid;

	private Integer ptid;

	private Integer uid;

	private String name;

	private String startdate;

	private String enddate;

	private Integer flgid;

	private Integer puid;

	private Integer ecid;

	private Integer ocid;

	private Integer psid;

	private Timestamp createat;

}