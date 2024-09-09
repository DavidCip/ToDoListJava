package com.davidcip.taskbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TaskbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskbackendApplication.class, args);
	}
	
}
