package com.thy.airport.controller;

import com.thy.airport.dto.CityDTO;
import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.CityService;
import com.thy.airport.service.CountryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "*",allowedHeaders = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {
  private final CityService cityService;

  @GetMapping("/list")
  public ResponsePayload<List<CityDTO>> listCity(){
    return cityService.list();
  }
}
