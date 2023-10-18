package com.thy.airport.mapper;

import com.thy.airport.dto.CountryDTO;
import com.thy.airport.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoMapper {
  public Country convertToEntity(CountryDTO countryDTO) {
    return countryDTO.convertToEntity(countryDTO);
  }
}
