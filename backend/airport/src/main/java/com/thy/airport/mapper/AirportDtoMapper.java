package com.thy.airport.mapper;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Country;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AirportDtoMapper {
  public Airport convertToEntity(AirportDTO airportDTO){
    return airportDTO.convertToEntity(airportDTO);
  }
  public AirportDTO map(Airport airport){
    return AirportDTO.builder()
        .id(airport.getId())
        .name(airport.getName())
        .build();
  }
  public List<AirportDTO> mapList(List<Airport> list) {
    List<AirportDTO> mappedList = new ArrayList<>();
    for (Airport airport : list) {
      mappedList.add(this.map(airport));
    }
    return mappedList;
  }
}
