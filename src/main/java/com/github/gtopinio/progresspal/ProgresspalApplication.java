package com.github.gtopinio.progresspal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProgresspalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgresspalApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "This is the ProgressPal Backend Server :D";
	}
}
