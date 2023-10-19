package com.thy.airport.bean.city;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.CityDTO;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.City;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.mapper.CityDtoMapper;
import com.thy.airport.repository.AirportRepository;
import com.thy.airport.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListCityBean extends AbstractResponsePayload {
  private final CityRepository repo;
  private final CityDtoMapper mapper;

  public ResponsePayload<List<CityDTO>> list(){
    return setResponse(mapper.mapList((List<City>) repo.findAll()));
  }
}
