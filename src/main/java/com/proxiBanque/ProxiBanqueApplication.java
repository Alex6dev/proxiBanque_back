package com.proxiBanque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProxiBanqueApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(ProxiBanqueApplication.class); 
	
	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueApplication.class, args);
	}

}
