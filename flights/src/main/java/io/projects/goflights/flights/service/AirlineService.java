package io.projects.goflights.flights.service;

import io.projects.goflights.flights.dto.AirlineDTO;
import io.projects.goflights.flights.dto.FlightRequestDTO;
import io.projects.goflights.flights.dto.FlightResponseDTO;
import io.projects.goflights.flights.entity.Airline;
import io.projects.goflights.flights.mapper.AirlineMapper;
import io.projects.goflights.flights.repository.AirlineRepository;
import io.projects.goflights.flights.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@AllArgsConstructor
public class AirlineService {
    private AirlineRepository airlineRepository;
    private FlightRepository flightRepository;

    public void saveAirline(AirlineDTO airlineDTO){
        Airline airline = AirlineMapper.mapAirlinesDTOToAirlines(airlineDTO, new Airline());
        airlineRepository.save(airline);
    }

    public List<AirlineDTO> findAllAirlines(){
        List<Airline> airlineList = airlineRepository.findAll();
        List<AirlineDTO> airlineDTOList = new ArrayList<>();

        for(Airline airline: airlineList){
            airlineDTOList.add(AirlineMapper.mapAirlinesToDTO(new AirlineDTO(), airline));
        }
        return airlineDTOList;
    }

}
