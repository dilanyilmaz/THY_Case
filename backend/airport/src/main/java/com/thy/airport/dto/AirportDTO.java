package com.thy.airport.dto;

import com.thy.airport.entity.Airport;
import com.thy.airport.mapper.CityDtoMapper;
import javax.persistence.Column;
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
public class AirportDTO {

  private int id;
  private String name;
  private String code;
  private CityDTO city;

  public Airport convertToEntity(AirportDTO airportDTO){
    Airport airport = new Airport();
    airport.setId(airportDTO.getId());
    airport.setCode(airportDTO.getCode());
    airport.setName(airportDTO.getName());
     return airport;
  }
}
