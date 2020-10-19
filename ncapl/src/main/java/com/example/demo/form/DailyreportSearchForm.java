package com.example.demo.form;

import com.example.demo.model.Production_daily_report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyreportSearchForm extends Production_daily_report {
	private String recorddateEnd;
}
