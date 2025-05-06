package io.projects.goflights.flights.mapper;

import io.projects.goflights.flights.dto.FlightRequestDTO;
import io.projects.goflights.flights.dto.FlightResponseDTO;
import io.projects.goflights.flights.entity.Flight;

public class FlightMapper {

    public static Flight mapToFlight(FlightRequestDTO flightRequestDTO, Flight flight){
        flight.setAirlineId(flightRequestDTO.getAirlineId());
        flight.setOrigin(flightRequestDTO.getOrigin());
        flight.setDestination(flightRequestDTO.getDestination());
        flight.setPrice(flightRequestDTO.getPrice());
        flight.setDepartureTime(flightRequestDTO.getDepartureTime());
        flight.setArrivalTime(flightRequestDTO.getArrivalTime());
        return flight;
    }

    public static FlightResponseDTO mapToFlightDTO(FlightResponseDTO flightResponseDTO, Flight flight){
        flightResponseDTO.setAirlineId(flight.getAirlineId());
        flightResponseDTO.setOrigin(flight.getOrigin());
        flightResponseDTO.setDestination(flight.getDestination());
        flightResponseDTO.setPrice(flight.getPrice());
        flightResponseDTO.setDepartureTime(flight.getDepartureTime());
        flightResponseDTO.setArrivalTime(flight.getArrivalTime());
        flightResponseDTO.setFlightId(flight.getFlightId());
        return flightResponseDTO;
    }
}
