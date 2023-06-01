package com.umcSpring.week06Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week06AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week06AssignmentApplication.class, args);
	}

}
