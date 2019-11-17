package com.mytechtra.spring.FlightYatra.core.flightservice.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
	
	@Pointcut("within(com.mytechtra.spring.FlightYatra.core.flightservice.web.*)")
	public void controllers() {}
	
	@Pointcut("within(com.mytechtra.spring.FlightYatra.core.pricing.*)")
	public void pricing() {}
	
	@Pointcut("@annotation(com.mytechtra.spring.FlightYatra.core.flightservice.web.aspect.Timmer)")
	public void timmer() {}
	
	@Before("controllers()")
	public void beforeAllMethodsInSpringPkg() {
		System.out.println(">> Method started");
	}
	
	@After("controllers()")
	public void afterAllMethodsInSpringPkg() {
		System.out.println("<< Method started");
	}

	
	@Around("timmer()")
	public Object arroundAllMethodsInSpringPkg(ProceedingJoinPoint jp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = jp.proceed();
		long stopTime = System.currentTimeMillis();
		System.out.println("time taken = "+ ((stopTime -startTime)/1000) + "secs");
		return result;
	}

}
