package com.amit.service;

import org.springframework.batch.item.ItemProcessor;

import com.amit.model.Report;

public class NewRecordProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		System.out.println("item from second record processor: "+item);
	//	throw new Exception("custom error");
		return item;
	}
}
