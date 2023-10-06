package com.recancheros.fieldsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FieldsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FieldsServiceApplication.class, args);
	}

}
