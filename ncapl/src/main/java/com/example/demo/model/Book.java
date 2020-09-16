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
@Table(name = "t_book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer jid;

	private Integer stid;

	private Integer agid;

	private Integer slid;

	private Integer uid;

	private Integer flgid;

	private Integer tid;

	private Integer fiid;

	private String recorddate;

	private Integer coid;

	private Integer cid;

	private String quantity;

	private Integer pid;

	private String selectedValue;

	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}

	public String getSelectedValue() {
		// TODO 自動生成されたメソッド・スタブ
		return selectedValue;
	}
}