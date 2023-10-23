package com.thy.airport.service.impl;

import com.thy.airport.bean.flight.ListFlightBean;
import com.thy.airport.dto.FlightDTO;
import com.thy.airport.dto.PredictiveInfos.Flights;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.mapper.FlightDtoMapper;
import com.thy.airport.repository.FlightRepository;
import com.thy.airport.service.FlightService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlightServiceImpl implements FlightService {
  private final ListFlightBean listFlightBean;

  @Override
  public ResponsePayload<List<FlightDTO>> list() {
    return listFlightBean.list();
  }

  @Override
  public ResponsePayload<List<Flights>> listFlights(int arrivalId, int departureId) {
    ResponsePayload<List<Flights>> listResponsePayload = listFlightBean.listFlights(arrivalId, departureId);
    return listResponsePayload;
  }
}
