package io.projects.goflights.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Data@AllArgsConstructor@Getter@Setter
public class FlightRequestDTO {
    private int airlineId;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Float price;
}
