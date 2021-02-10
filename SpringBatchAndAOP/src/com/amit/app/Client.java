package com.amit.app;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	//	Job job = (Job) context.getBean("reportJob");
		try {
	//		JobExecution execution = jobLauncher.run(job, new JobParameters());
	//		System.out.println("Exit Status : " + execution.getStatus());
			Job job = (Job) context.getBean("dbReaderJob");
			JobParameters params= new JobParametersBuilder().addString("dummyParam", "test val").toJobParameters();
			JobExecution execution = jobLauncher.run(job, params);
			if(execution.getStatus()== BatchStatus.FAILED)
			{
				System.out.println("Retrying the job");
				jobLauncher.run(job, params);
			}
			System.out.println("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			System.out.println("Error: " + e.getStackTrace());
		}
	}
}
