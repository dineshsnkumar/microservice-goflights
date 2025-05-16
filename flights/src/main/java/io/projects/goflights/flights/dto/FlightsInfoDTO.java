package io.projects.goflights.flights.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(value = "flights")
@Getter
@Setter
public class FlightsInfoDTO {
    private String message;
    private Map<String,String> contact;
    private List<String> phoneNumber;
}
