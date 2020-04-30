package com.example.springtest;

import com.example.springtest.service.AppConfig;
import com.example.springtest.service.ComponentTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackageClasses = {ComponentTest.class})
public class SpringtestApplication {

	public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringtestApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringtestApplication.class);
		ComponentTest test = context.getBean(ComponentTest.class);
		System.out.println(test.getName());

	}

}
