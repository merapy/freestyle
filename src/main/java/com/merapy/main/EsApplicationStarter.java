package com.merapy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.merapy.*")
public class EsApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(EsApplicationStarter.class, args);
	}
}
