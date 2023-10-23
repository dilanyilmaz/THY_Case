package com.thy.airport.bean.flight;

import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.FlightDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.PredictiveInfos.Flights;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Country;
import com.thy.airport.entity.Flight;
import com.thy.airport.enumaration.MessageEnum;
import com.thy.airport.enumaration.ResponseEnum;
import com.thy.airport.mapper.CountryDtoMapper;
import com.thy.airport.mapper.FlightDtoMapper;
import com.thy.airport.repository.CountryRepository;
import com.thy.airport.repository.FlightRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListFlightBean extends AbstractResponsePayload {
  private final FlightRepository repo;
  private final FlightDtoMapper mapper;

  public ResponsePayload<List<FlightDTO>> list(){
    return setResponse(mapper.mapList((List<Flight>) repo.findAll()));
  }
  public ResponsePayload<List<Flights>> listFlights(int arrivalId,int departureId) {
    List<Flights> availableFlights = repo.getAvailableFlights(arrivalId, departureId);
    if(availableFlights.isEmpty()){
      return setResponse(ResponseEnum.NOTFOUND, MessageEnum.NOT_FOUND.getMessage());
    }
    return setResponse(availableFlights);
  }
}
