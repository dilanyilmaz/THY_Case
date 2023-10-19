package com.thy.airport.mapper;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.CityDTO;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.City;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CityDtoMapper {
  public City convertToEntity(CityDTO cityDTO){
    return cityDTO.convertToEntity(cityDTO);
  }
  public CityDTO map(City city){
    return CityDTO.builder()
        .id(city.getId())
        .city(city.getName())
        .country(city.getCountry()==null ? null : new CountryDtoMapper().map(city.getCountry()))
        .build();
  }
  public List<CityDTO> mapList(List<City> list) {
    List<CityDTO> mappedList = new ArrayList<>();
    for (City city : list) {
      mappedList.add(this.map(city));
    }
    return mappedList;
  }
}
