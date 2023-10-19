package com.thy.airport.repository;

import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Long> {
  @Query(nativeQuery = true,value =
      "SELECT COUNTRY.NAME as \"COUNTRY\",\n"
          + "CITY.NAME as \"CITY\",\n"
          + "AIRPORT.NAME as \"AIRPORT\"\n"
          + " FROM COUNTRY\n"
          + "INNER JOIN CITY ON COUNTRY.ID = CITY.COUNTRY_ID\n"
          + "INNER JOIN AIRPORT ON CITY.ID=AIRPORT.CITY_ID\n"
          + "WHERE COUNTRY.ID=:countryId")
 List<Airports> getAirportsByCountry(@Param("countryId") Long countryId);
}
