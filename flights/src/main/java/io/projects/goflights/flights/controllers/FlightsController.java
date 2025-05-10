package io.projects.goflights.flights.controllers;

import io.projects.goflights.flights.constants.FlightsConstants;
import io.projects.goflights.flights.dto.*;
import io.projects.goflights.flights.service.AirlineService;
import io.projects.goflights.flights.service.FlightService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    private AirlineService airlineService;
    private FlightService flightService;

    public FlightsController(FlightService flightService, AirlineService airlineService) {
        this.flightService = flightService;
        this.airlineService = airlineService;
    }

    @Autowired
    private FlightsInfoDTO flightsInfoDTO;

    @GetMapping
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights(){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights());
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<AirlineDTO>> getAllAirlines(){
        List<AirlineDTO> airlineDTOList = airlineService.findAllAirlines();
        return ResponseEntity.status(HttpStatus.OK).body(airlineDTOList);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightResponseDTO> getAllAirlines(@PathVariable String flightId){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.findFlightById(flightId));
    }


    @PostMapping
    public ResponseEntity<ResponseDTO> saveFlight(@RequestBody FlightRequestDTO flightRequestDTO){
        flightService.saveFlight(flightRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(FlightsConstants.MESSAGE_200, FlightsConstants.STATUS_200));
    }


    @PostMapping("/airline")
    public ResponseEntity<ResponseDTO> saveAirline(@RequestBody AirlineDTO airlineDTO){
        airlineService.saveAirline(airlineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(FlightsConstants.MESSAGE_200, FlightsConstants.STATUS_200));
    }

    @GetMapping("/flight-info")
    public ResponseEntity<FlightsInfoDTO> flightInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(flightsInfoDTO);
    }
}
