package com.etc.unit;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop {

	@Before(value="execution(* com.etc.service.*.*(..))")
	public void start()
	{
		System.out.println("start:"+System.currentTimeMillis());
	}
	
	@After(value="execution(* com.etc.service.*.*(..))")
	public void end()
	{
		System.out.println("end:"+System.currentTimeMillis());
	}
	
}
