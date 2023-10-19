package com.thy.airport.repository;

import com.thy.airport.dto.PredictiveInfos.Airports;
import com.thy.airport.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {


}
