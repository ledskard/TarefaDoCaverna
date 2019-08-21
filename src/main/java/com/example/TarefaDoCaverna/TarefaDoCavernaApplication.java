package com.example.TarefaDoCaverna;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TarefaDoCavernaApplication {

	@PostConstruct
	private void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TarefaDoCavernaApplication.class, args);
	}

}