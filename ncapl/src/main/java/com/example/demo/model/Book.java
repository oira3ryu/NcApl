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
@Table(name="t_book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer j_id;

    private Integer st_id;

    private Integer ag_id;

    private Integer sl_id;

    private Integer u_id;

    private Integer flg_id;

    private Integer t_id;

    private Integer fi_id;

    private String record_date;

    private Integer co_id;

    private String quantity;

    private Integer p_id;
}