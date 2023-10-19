package com.thy.airport.service.impl;

import com.thy.airport.bean.airport.ListAirportBean;
import com.thy.airport.bean.city.ListCityBean;
import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.CityDTO;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.CityService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityServiceImpl implements CityService {

  private final ListCityBean listCityBean;
  @Override
  public ResponsePayload<List<CityDTO>> list() {
    return listCityBean.list();
  }
}
