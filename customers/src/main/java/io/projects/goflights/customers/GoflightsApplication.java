package io.projects.goflights.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class GoflightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoflightsApplication.class, args);
	}

}
