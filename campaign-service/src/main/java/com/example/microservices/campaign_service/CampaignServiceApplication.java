package com.example.microservices.campaign_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CampaignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignServiceApplication.class, args);
	}

}
