package com.ashu16.microservice.curreencyconversoinservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurreencyConversoinServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurreencyConversoinServiceApplication.class, args);
	}

}
