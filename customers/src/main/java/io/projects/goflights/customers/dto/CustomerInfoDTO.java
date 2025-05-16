package io.projects.goflights.customers.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "customers")
@Getter
@Setter
public class CustomerInfoDTO {
    private String message;
    private Map<String, String> contact;
    private List<String> phoneNumber;
}
