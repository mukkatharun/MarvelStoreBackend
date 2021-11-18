package com.example.marvelstore.MarvelStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarvelStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarvelStoreApplication.class, args);
	}
}
