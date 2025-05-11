package io.projects.goflights.customers.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "customers")
public record CustomerInfoDTO(String message, Map<String, String> contact, List<String> phoneNumber) {
}
