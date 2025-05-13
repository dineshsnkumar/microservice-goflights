package io.projects.goflights.customers;

import io.projects.goflights.customers.dto.CustomerInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CustomerInfoDTO.class})
public class GoflightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoflightsApplication.class, args);
	}

}
