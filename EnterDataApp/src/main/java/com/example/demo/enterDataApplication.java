package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class enterDataApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(enterDataApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
