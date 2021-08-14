package com.omnirio.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ProductIntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductIntegrationServiceApplication.class, args);
		System.out.println("Hello World");
	}

}
