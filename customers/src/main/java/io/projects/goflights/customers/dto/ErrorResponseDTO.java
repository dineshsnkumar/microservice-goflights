package io.projects.goflights.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data@AllArgsConstructor
public class ErrorResponseDTO {
    private String api;
    private HttpStatus errorCode;
    private String errorMsG;
    private LocalDateTime time;
}
