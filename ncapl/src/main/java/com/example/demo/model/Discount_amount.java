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
@Table(name="t_discount_amount")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Discount_amount {
	   @Id
	    @Column(name="id")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name="coid")
	    private Integer coid;

	    @Column(name="amount")
	    private Integer amount;

	    @Column(name="startdate")
	    private String startdate;

	    @Column(name="enddate")
	    private String enddate;

	    @Column(name="flgid")
		private Integer flgid;

	    @Column(name="createat")
		private Timestamp createat;
}
