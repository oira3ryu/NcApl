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
@Table(name = "t_product_master")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product_master {
	@Id
	@Column(name = "pm_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pm_id;

	//private Integer st_id;

	//private Integer ag_id;

	//private Integer sl_id;

	private Integer pn_id;

	//private String product_name;

	private String cement_adjv;

	private String sand_adjv;

	private String stone_adjv;

	private String sp_price;

	private String std_price;

	private String start_date;

	private String end_date;

	private Integer flg_id;

	//private String value;

	private Timestamp create_at;

//	private String selectedValue;

//	public void setSelectedValue(String selectedValue) {
//		this.selectedValue = selectedValue;
//	}
//
//	public String getSelectedValue() {
//		// TODO 自動生成されたメソッド・スタブ
//		return selectedValue;
//	}
}