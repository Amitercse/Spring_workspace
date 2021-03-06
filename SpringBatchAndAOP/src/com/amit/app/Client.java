package com.amit.app;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amit.aop.AOPService;
import com.amit.aop.MockAOPService;

public class Client {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		runFirstJob(jobLauncher, context);
		runSecondJob(jobLauncher, context);
		aopVerification(context);
	}
	
	private static void runFirstJob(JobLauncher jobLauncher, ApplicationContext context) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		Job job = (Job) context.getBean("reportJob");
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
	}
	
	private static void runSecondJob(JobLauncher jobLauncher, ApplicationContext context) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		Job job2 = (Job) context.getBean("dbReaderJob");
		JobParameters params= new JobParametersBuilder().addString("dummyParam", "test val").toJobParameters();
		JobExecution execution2 = jobLauncher.run(job2, params);
		if(execution2.getStatus()== BatchStatus.FAILED)
		{
			System.out.println("Retrying the job");
			jobLauncher.run(job2, params);
		}
		System.out.println("Exit Status : " + execution2.getStatus());
	}
	
	private static void aopVerification(ApplicationContext context) {
		AOPService service = context.getBean(AOPService.class);
		MockAOPService mockService = context.getBean(MockAOPService.class);
		service.getDummyData();
		service.saveData("123", "User 1");
		try {
			service.checkCompletionOrException();
		} catch (Exception e) {
			System.out.println("Custom error");
		}  
		service.checkAroundAdvice();
		System.out.println("\n================== Executing mock service =====================");
		mockService.getMockData();
	}
}
