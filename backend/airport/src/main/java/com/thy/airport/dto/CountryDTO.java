package com.thy.airport.dto;

import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Country;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.mapper.CountryDtoMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CountryDTO {

  private Long id;
  private String country;
  private String city;
  private AirportDTO airportDTO;

  public Country convertToEntity(CountryDTO countryDTO){
    Country country = new Country();
    country.setId(countryDTO.getId());
    country.setCity(countryDTO.getCity());
    country.setCountry(countryDTO.getCountry());
    country.setAirport(countryDTO.getAirportDTO()!=null ? new AirportDtoMapper().convertToEntity(countryDTO.getAirportDTO()) :null);
    return country;
  }
}
