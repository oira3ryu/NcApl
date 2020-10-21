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
@Table(name = "t_price_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Price_list {
	@Id
	@Column(name = "plid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plid;

	private Integer pnid;

	private String spprice;

	private String stdprice;

	private String startdate;

	private String enddate;

	private Integer flgid;

	private String createat;

}
