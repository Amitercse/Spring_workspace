package com.amit.app;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.amit.model.Report;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Value("${file.input}")
    private String fileInput;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Bean
	@StepScope
	public FlatFileItemReader<Report> reportReader() {
		return new FlatFileItemReaderBuilder<Report>().saveState(false).resource(new ClassPathResource(fileInput))
				.delimited().names("userId", "name", "transactionDate", "transactionAmount").linesToSkip(1)
				.fieldSetMapper(fieldMapper()).build();
	}
	
	@Bean
	@StepScope
	public BeanWrapperFieldSetMapper<Report> fieldMapper()
	{
		BeanWrapperFieldSetMapper<Report> fieldMapper= new BeanWrapperFieldSetMapper<>();
		fieldMapper.setPrototypeBeanName("report");
		return fieldMapper;
	}
	
	@Bean
	@StepScope
	@Autowired
	public ItemWriter<Report> reportWriter() {
	    return new JdbcBatchItemWriterBuilder<Report>().namedParametersJdbcTemplate(namedParameterJdbcTemplate)
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("insert into transaction_report(user_id,name,transaction_date,transaction_amount) values (:userId, :name, :transactionDate, :transactionAmount)")
	      .build();
	}
	
	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<Report, Report>chunk(2).reader(reportReader())
				.writer(reportWriter()).build();
	}
	
	@Bean
	@Autowired
	public Job processJob(JobBuilderFactory jobBuilderFactory) {
		return jobBuilderFactory.get("processJob").flow(orderStep1()).end().build();
	}
	
}
