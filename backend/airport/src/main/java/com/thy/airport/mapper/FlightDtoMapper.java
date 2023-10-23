package com.thy.airport.mapper;

import com.thy.airport.dto.FlightDTO;
import com.thy.airport.entity.Flight;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FlightDtoMapper {
  public Flight convertToEntity(FlightDTO flightDTO){
    return flightDTO.convertToEntity(flightDTO);
  }
  public FlightDTO map(Flight flight){
    return FlightDTO.builder()
        .id(flight.getId())
        .departureDate(flight.getDepartureDate())
        .arrivalDate(flight.getArrivalDate())
        .pilotFirstName(flight.getPilotFirstName())
        .pilotLastName(flight.getPilotLastName())
  //      .departureAirportId(flight.getDepartureAirportId()==null?null:new AirportDtoMapper().map(flight.getArrivalAirportId()))
  //      .arrivalAirportId(flight.getArrivalAirportId()==null?null:new AirportDtoMapper().map(flight.getArrivalAirportId()))
        .build();
  }
  public List<FlightDTO> mapList(List<Flight> list){
    List<FlightDTO> mapperList = new ArrayList<>();
    for(Flight flight : list){
      mapperList.add(this.map(flight));
    }
    return mapperList;
  }
}
