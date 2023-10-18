package com.thy.airport.service.impl;

import com.thy.airport.bean.airport.ListAirportBean;
import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.AirportService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AirportServiceImpl implements AirportService {

  private final ListAirportBean listAirportBean;
  @Override
  public ResponsePayload<List<AirportDTO>> list() {
    return listAirportBean.list();
  }
}
