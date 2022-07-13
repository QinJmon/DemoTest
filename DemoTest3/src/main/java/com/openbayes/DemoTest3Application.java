package com.openbayes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.openbayes"})
public class DemoTest3Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoTest3Application.class, args);
	}

}
