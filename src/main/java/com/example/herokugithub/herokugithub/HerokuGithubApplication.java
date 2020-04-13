package com.example.herokugithub.herokugithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class HerokuGithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(HerokuGithubApplication.class, args);
	}

}
