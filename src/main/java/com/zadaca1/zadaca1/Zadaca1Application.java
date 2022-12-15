package com.zadaca1.zadaca1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class Zadaca1Application {

	public static void main(String[] args) {
		SpringApplication.run(Zadaca1Application.class, args);
	}

	@GetMapping("")
    public String viewHomePage() {
        return "index";
    }

}
