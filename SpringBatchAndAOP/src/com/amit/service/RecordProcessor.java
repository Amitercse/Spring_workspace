package com.amit.service;

import org.springframework.batch.item.ItemProcessor;

import com.amit.model.Report;

public class RecordProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		System.out.println("item from first record processor: "+item);
		return item;
	}

}
