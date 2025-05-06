package io.projects.goflights.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data@AllArgsConstructor
public class ErrorResponseDTO {

    String errorPath;
    String errorMessage;
    LocalDateTime localDateTime;
}
