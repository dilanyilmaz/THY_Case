package com.thy.airport.bean.airport;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Airport;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.repository.AirportRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListAirportBean extends AbstractResponsePayload {

  private final AirportRepository repo;
  private final AirportDtoMapper mapper;

  public ResponsePayload<List<AirportDTO>> list() {
    return setResponse(mapper.mapList((List<Airport>) repo.findAll()));
  }

  public ResponsePayload<List<Airports>> listbyCounty(Long id) {
    List<Airports> airportsByCountry = repo.getAirportsByCountry(id);
    return setResponse(airportsByCountry);
  }
}
