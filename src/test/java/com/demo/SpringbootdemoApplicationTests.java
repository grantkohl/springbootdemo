package com.demo;

import com.demo.annotation.AnnotationDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Configuration 配置spring容器(应用上下文),类似于<beans></>
 */
@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Test
	public void contextLoads() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(SpringbootdemoApplicationTests.class);
		annotationConfigApplicationContext.refresh();
		InjectClass injectClass = annotationConfigApplicationContext.getBean(InjectClass.class);
		injectClass.print();
	}

	@AnnotationDemo
	public static class InjectClass {
		public void print() {
			System.out.println("hello world");
		}
	}

}
