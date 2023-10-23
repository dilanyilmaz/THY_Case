package com.thy.airport.controller;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.repository.AirportRepository;
import com.thy.airport.service.AirportService;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airport")
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportController {
  private final AirportService airportService;
  private final AirportRepository airportRepository;

  //this method can be accessed by user whose role is user
  @RolesAllowed("user")
  @GetMapping(value = "/listAirports")
  public ResponsePayload<List<AirportDTO>> listAirports(){
    return airportService.list();
  }

  //this method can be accessed by user whose role is admin
  @RolesAllowed("admin")
  @GetMapping(value = "/listAirportsByCountry")
  public ResponsePayload<List<Airports>> listAirportsByCountry(@RequestParam(value = "id") int id){
    System.out.println(airportService.listAirport(id).getData());
    return airportService.listAirport(id);
  }
  @GetMapping(value = "/byId")
  public ResponsePayload<AirportDTO> getAirportById(@RequestParam("id") int id) {
    System.out.println(airportService.getAirportById(id).getData());
    return airportService.getAirportById(id);
  }
  @PostMapping(value = "/save")
  public ResponsePayload<AirportDTO> save(@RequestBody AirportDTO airportDTO) {
    return airportService.save(airportDTO);
  }
  @PutMapping(value = "/update")
  public ResponsePayload<AirportDTO> update(@RequestBody AirportDTO airportDTO) {
    return airportService.update(airportDTO);
  }
  @DeleteMapping(value = "/deleteById")
  public ResponsePayload<AirportDTO> deleteById(@RequestParam("id") int id) {
    return airportService.deleteById(id);
  }
}
