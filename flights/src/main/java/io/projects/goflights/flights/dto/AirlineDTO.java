package io.projects.goflights.flights.dto;

import lombok.*;

@Data@AllArgsConstructor@Setter@Getter@NoArgsConstructor
public class AirlineDTO {
    private String name;
    private String iatoCode;
    private String icaoCode;
    private String country;
}
