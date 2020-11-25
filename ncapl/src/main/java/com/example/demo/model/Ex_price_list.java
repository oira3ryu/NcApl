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
@Table(name = "t_ex_price_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Ex_price_list {
	@Id
	@Column(name = "explid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer explid;

	private Integer id;

	private String spprice;

	private String stdprice;

	private String startdate;

	private String enddate;

	private Integer flgid;

	private Timestamp createat;

}
