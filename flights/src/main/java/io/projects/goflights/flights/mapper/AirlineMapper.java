package io.projects.goflights.flights.mapper;

import io.projects.goflights.flights.dto.AirlineDTO;
import io.projects.goflights.flights.entity.Airline;

public class AirlineMapper {

    public static AirlineDTO mapAirlinesToDTO(AirlineDTO airlineDTO, Airline airline){
        airlineDTO.setName(airline.getName());
        airlineDTO.setIatoCode(airline.getIatoCode());
        airlineDTO.setIcaoCode(airline.getIcaoCode());
        airlineDTO.setCountry(airline.getCountry());
        return airlineDTO;
    }

    public static Airline mapAirlinesDTOToAirlines(AirlineDTO airlineDTO, Airline airline){
        airline.setName(airlineDTO.getName());
        airline.setIatoCode(airlineDTO.getIatoCode());
        airline.setIcaoCode(airlineDTO.getIcaoCode());
        airline.setCountry(airlineDTO.getCountry());
        return airline;
    }
}
