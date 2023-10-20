package com.thy.airport.service;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.core.ResponsePayload;
import java.util.List;

public interface AirportService {
  ResponsePayload<List<AirportDTO>> list();
  ResponsePayload<List<Airports>> listA(int id);
}
