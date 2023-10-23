package com.thy.airport.service;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.core.ResponsePayload;
import java.util.List;

public interface AirportService {
  ResponsePayload<List<AirportDTO>> list();
  ResponsePayload<List<Airports>> listAirport(int id);

  ResponsePayload<AirportDTO> getAirportById(int id);

  ResponsePayload<AirportDTO> save(AirportDTO airportDTO);

  ResponsePayload<AirportDTO> update(AirportDTO airportDTO);

  ResponsePayload<AirportDTO> deleteById(int id);
}
