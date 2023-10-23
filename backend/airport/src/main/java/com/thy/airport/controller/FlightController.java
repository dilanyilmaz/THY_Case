package com.thy.airport.controller;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.FlightDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.PredictiveInfos.Flights;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.FlightService;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightController {

  private final FlightService flightService;
  public ResponsePayload<List<FlightDTO>> listFlight(){return flightService.list();}

  @GetMapping(value = "/listAirportsByCountry")
  public ResponsePayload<List<Flights>> listAirportsByCountry(@RequestParam(value = "arrivalId") int arrivalId,
      @RequestParam(value = "departureId") int departureId){
    return flightService.listFlights(arrivalId,departureId);
  }

}
