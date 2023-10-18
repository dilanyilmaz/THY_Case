package com.thy.airport.controller;

import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.CountryService;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController {
  private final CountryService countryService;
  @GetMapping("/country")
  public ResponsePayload<List<CountryDTO>> listCountrys(){
    return countryService.list();
  }

}
