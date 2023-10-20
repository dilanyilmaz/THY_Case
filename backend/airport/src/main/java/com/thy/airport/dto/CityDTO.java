package com.thy.airport.dto;

import com.thy.airport.entity.Airport;
import com.thy.airport.entity.City;
import com.thy.airport.entity.Country;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.mapper.CityDtoMapper;
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
public class CityDTO {

  private int id;
  private String city;
  private CountryDTO country;
  public City convertToEntity(CityDTO cityDTO) {
    City city = new City();
    city.setId(cityDTO.getId());
    city.setName(cityDTO.getCity());
    city.setCountry(cityDTO.getCountry()!=null?new CountryDtoMapper().convertToEntity(cityDTO.getCountry()):null);
    return city;
  }
}
