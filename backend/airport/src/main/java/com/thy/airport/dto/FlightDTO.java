package com.thy.airport.dto;

import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Flight;
import com.thy.airport.mapper.AirportDtoMapper;
import java.util.Date;
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
public class FlightDTO {
  private int id;
 private Date departureDate;
  private Date arrivalDate;
  private String pilotFirstName;
  private String pilotLastName;
  private AirportDTO departureAirportId;
  private AirportDTO arrivalAirportId;

  public Flight convertToEntity(FlightDTO flightDTO){
    Flight flight = new Flight();
    flight.setId(flightDTO.getId());
   flight.setDepartureDate(flightDTO.getDepartureDate());
   flight.setArrivalDate(flightDTO.getArrivalDate());
    flight.setPilotFirstName(flightDTO.getPilotFirstName());
    flight.setPilotLastName(flightDTO.getPilotLastName());
   flight.setDepartureAirportId(flightDTO.getDepartureAirportId()!=null?new AirportDtoMapper().convertToEntity(flightDTO.getDepartureAirportId()):null);
   flight.setArrivalAirportId(flightDTO.getArrivalAirportId()!=null?new AirportDtoMapper().convertToEntity(flightDTO.getArrivalAirportId()):null);
    return flight;
  }
}
