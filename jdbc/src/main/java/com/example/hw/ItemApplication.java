package com.example.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;


@EntityScan(basePackages =  {"com.example.hw"})
@SpringBootApplication
public class ItemApplication {
	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(ItemApplication.class, args);
	 ForeignKeyBasedRun foreignKeyBased = context.getBean(
	 ForeignKeyBasedRun.class); 
	 foreignKeyBased.sampleRun();
	 
	}
	

}
