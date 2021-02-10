package com.amit.service;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import com.amit.model.Report;

public class NewRecordProcessor implements ItemProcessor<Report, Report> {
	
	@Value("#{jobParameters['dummyParam']}")
	private String dummyParam;

	@Override
	public Report process(Report item) throws Exception {
		System.out.println("dummy param: "+dummyParam);
		System.out.println("item from second record processor: "+item);
	//	throw new Exception("custom error");
		return item;
	}
}
