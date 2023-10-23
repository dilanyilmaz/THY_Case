package com.thy.airport.repository;

import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.PredictiveInfos.Flights;
import com.thy.airport.entity.Flight;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository  extends CrudRepository<Flight,Integer> {
  @Query(nativeQuery = true,value = "SELECT AIRPORT.CODE, AIRPORT.NAME AS \"AIRPORT_NAME\",\n"
      + "    CITY.NAME AS \"CITY\", COUNTRY.NAME AS \"COUNTRY\" FROM FLIGHT\n"
      + "    JOIN AIRPORT ON AIRPORT.ID=FLIGHT.ARRIVAL_AIRPORT_ID OR AIRPORT.ID=FLIGHT.DEPARTURE_AIRPORT_ID\n"
      + "    JOIN CITY ON AIRPORT.CITY_ID=CITY.ID\n"
      + "    JOIN COUNTRY ON CITY.COUNTRY_ID=COUNTRY.ID\n"
      + "    WHERE AIRPORT.ID =:arrivalId OR AIRPORT.ID =:departureId")
  List<Flights> getAvailableFlights(@Param("arrivalId") int arrivalId,@Param("departureId") int departureId);
}