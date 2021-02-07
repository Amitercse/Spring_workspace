package com.amit.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amit.model.Report;

public class ReportResultRowMapper implements RowMapper<Report> {

	@Override
	public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
		Report report= new Report();
		report.setUserId(rs.getString("user_id"));
		report.setName(rs.getString("name"));
		report.setTransactionAmount(rs.getString("transaction_amount"));
		report.setTransactionDate(rs.getString("transaction_date"));
		return report;
	}

	
}
