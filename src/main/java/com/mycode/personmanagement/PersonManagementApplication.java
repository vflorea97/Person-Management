package com.mycode.personmanagement;

import com.mycode.personmanagement.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(View view) {
		return args -> {
			view.play();
		};
	}
}
