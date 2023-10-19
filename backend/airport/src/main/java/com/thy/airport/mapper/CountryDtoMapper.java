package com.thy.airport.mapper;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Country;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoMapper {
  public Country convertToEntity(CountryDTO countryDTO) {
    return countryDTO.convertToEntity(countryDTO);
  }
  public CountryDTO map(Country country){
    return CountryDTO.builder()
        .id(country.getId())
        .country(country.getName())
        .build();
  }
  public List<CountryDTO> mapList(List<Country> list) {
    List<CountryDTO> mappedList = new ArrayList<>();
    for (Country country : list) {
      mappedList.add(this.map(country));
    }
    return mappedList;
  }

}
