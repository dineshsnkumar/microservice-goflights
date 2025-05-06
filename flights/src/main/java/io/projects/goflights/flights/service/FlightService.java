package io.projects.goflights.flights.service;

import io.projects.goflights.flights.dto.FlightRequestDTO;
import io.projects.goflights.flights.dto.FlightResponseDTO;
import io.projects.goflights.flights.entity.Airline;
import io.projects.goflights.flights.entity.Flight;
import io.projects.goflights.flights.exception.RecordNotFoundException;
import io.projects.goflights.flights.mapper.FlightMapper;
import io.projects.goflights.flights.repository.AirlineRepository;
import io.projects.goflights.flights.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class FlightService {

    private FlightRepository flightRepository;


    public void saveFlight(FlightRequestDTO flightDTO)  {
       Flight flight =  FlightMapper.mapToFlight(flightDTO, new Flight());
       flightRepository.save(flight);
    }

    public List<FlightResponseDTO> getAllFlights(){
        List<Flight> flightList =  flightRepository.findAll();
        List<FlightResponseDTO> flightResponseDTOList = new ArrayList<>();

        for (Flight flight : flightList){
            flightResponseDTOList.add(FlightMapper.mapToFlightDTO(new FlightResponseDTO(), flight));
        }

        return flightResponseDTOList;
    }

    public FlightResponseDTO findFlightById(String flightId)  {
        Optional<Flight> flight = flightRepository.findById(Integer.parseInt(flightId));
        return FlightMapper.mapToFlightDTO(new FlightResponseDTO(), flight.get());
    }

}
