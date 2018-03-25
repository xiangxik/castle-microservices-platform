package com.whenling.module.basic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BasicApplication.class).run(args);
	}
}
