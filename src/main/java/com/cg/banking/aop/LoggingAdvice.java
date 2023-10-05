package com.cg.banking.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Autowired ObjectMapper mapper;
	
	@Pointcut(value = "execution(* com.cg.banking.services.*.*(..) )")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();

		log.info("Method invoked " + className + " : " + methodName + "()" + "arguments "
				+ mapper.writeValueAsString(array));
		log.info("Hello");

		mapper.writeValueAsString(array);
		Object object = pjp.proceed();

		 //Capture the response
		log.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object));

		return object;
	}
}
