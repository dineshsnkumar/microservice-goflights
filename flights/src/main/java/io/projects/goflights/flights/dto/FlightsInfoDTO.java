package io.projects.goflights.flights.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(value = "flights")
public record FlightsInfoDTO(String message, Map<String,String> contact, List<String> phoneNumber) {
}
