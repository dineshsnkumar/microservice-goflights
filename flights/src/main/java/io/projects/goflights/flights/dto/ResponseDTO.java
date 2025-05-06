package io.projects.goflights.flights.dto;

import lombok.*;

@Data
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class ResponseDTO {
    private String message;
    private String statusCode;
}
