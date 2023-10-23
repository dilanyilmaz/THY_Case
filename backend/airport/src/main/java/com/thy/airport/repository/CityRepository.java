package com.thy.airport.repository;

import com.thy.airport.entity.Airport;
import com.thy.airport.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends CrudRepository<City,Integer> {

}
