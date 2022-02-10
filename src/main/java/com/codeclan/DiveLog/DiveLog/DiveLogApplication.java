package com.codeclan.DiveLog.DiveLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.codeclan.DiveLog.DiveLog.Utility")
//@EnableJpaRepositories("com.codeclan.DiveLog.DiveLog.repositories")
public class DiveLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveLogApplication.class, args);
	}

}
