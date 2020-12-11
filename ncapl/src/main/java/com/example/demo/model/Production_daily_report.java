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
	@Column(name = "pdrid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdrid;

	private Integer pid;

	private Integer coid;

	private Integer pnid;

	private Integer fiid;

	private Integer exid;

	private String quantity;

	private String recorddate;

	public String getRecorddateEnd() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public int spsalesamount() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}