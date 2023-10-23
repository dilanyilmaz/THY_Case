package com.thy.airport.service;



import com.thy.airport.dto.FlightDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.PredictiveInfos.Flights;
import com.thy.airport.dto.core.ResponsePayload;
import java.util.List;

public interface FlightService {
  ResponsePayload<List<FlightDTO>> list();
  ResponsePayload<List<Flights>> listFlights(int arrivalId,int departureId);

}
