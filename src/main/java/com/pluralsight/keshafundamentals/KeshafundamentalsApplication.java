package com.pluralsight.keshafundamentals;

import com.pluralsight.keshafundamentals.entity.Application;
import com.pluralsight.keshafundamentals.entity.Ticket;
import com.pluralsight.keshafundamentals.repository.ApplicationRepository;
import com.pluralsight.keshafundamentals.repository.TicketRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@SpringBootApplication is 3 in 1
//@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
public class KeshafundamentalsApplication {

	private static final Logger log = LoggerFactory.getLogger(KeshafundamentalsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KeshafundamentalsApplication.class, args);
		log.info("Hello! Running Keshafundamentals Application.");
	}

	
	@Bean
	public CommandLineRunner demo(ApplicationRepository appRepository, TicketRepository ticketRepository ) {
		return args -> {
			//Add Dummy data
			Application app1 = appRepository.save(new Application("Trackzilla","kesha.williams","Application for tracking bugs."));
			appRepository.save(new Application("Expenses","mary.jones","Application to track expense reports."));
			appRepository.save(new Application("Notifications","karen.kane","Application to send alerts and notifications to users."));

			ticketRepository.save(new Ticket("Error One", "description", app1, "open"));
			/*
			for (Application application : appRepository.findAll()) {
				log.info("The application is: " + application.toString());
			}
			*/
			
		};
	}


}
