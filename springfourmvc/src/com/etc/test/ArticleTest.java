package com.etc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.service.ArticleService;

public class ArticleTest {

	ClassPathXmlApplicationContext cpac = null;

	@Before
	public void init() {
		cpac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
}
