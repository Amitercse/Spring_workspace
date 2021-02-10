package com.amit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

	@Before("execution(* com.amit.aop.*.*(..))")
	public void beforeExecLogging(JoinPoint joinPoint)
	{
		System.out.println("entering in method: "+ joinPoint.getSignature());
	}
	
	@After("execution(* com.amit.aop.*.*(..))")
	public void afterExecLogging(JoinPoint joinPoint)
	{
		System.out.println("Exiting from method: "+ joinPoint.getSignature());
	}
	
	@Before("execution(* com.amit.aop.*.save*(..))")
	public void openTransaction(JoinPoint joinPoint)
	{
		// Code to open the transaction before savign data
		System.out.println("Opening transaction to save data for method: "+ joinPoint.getSignature());
	}
	
	@AfterThrowing("execution(* com.amit.aop.AOPService.checkCompletionOrException())")
	public void checkException(JoinPoint jointPoint) {
		System.out.println("Checking the exception thrown by method: "+ jointPoint.getSignature());
	}
	
	@AfterReturning("execution(* com.amit.aop.AOPService.checkCompletionOrException())")
	public void afterCompletion(JoinPoint jointPoint) {
		System.out.println("Checking the successful completion of method: "+ jointPoint.getSignature());
	}
	
	@Around("execution(* com.amit.aop.AOPService.checkAroundAdvice(..))")
	public void checkAroundAdvice(ProceedingJoinPoint jointPoint)
	{
		System.out.println("Checking around advice before execution for method: "+jointPoint.getSignature());
		try {
			jointPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Checking around advice after execution for method: "+jointPoint.getSignature());

	}
}
