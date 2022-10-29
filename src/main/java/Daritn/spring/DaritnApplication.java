package Daritn.spring;


import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DaritnApplication {
	public static void main(String[] args) {
		SpringApplication.run(DaritnApplication.class, args);
	}

}
