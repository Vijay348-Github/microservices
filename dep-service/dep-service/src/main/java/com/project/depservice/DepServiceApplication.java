package com.project.depservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepServiceApplication.class, args);
	}

}
