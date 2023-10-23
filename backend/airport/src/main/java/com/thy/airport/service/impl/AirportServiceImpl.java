package com.thy.airport.service.impl;

import com.thy.airport.bean.airport.DeleteAirportBean;
import com.thy.airport.bean.airport.FindAirportBean;
import com.thy.airport.bean.airport.ListAirportBean;
import com.thy.airport.bean.airport.SaveAirportBean;
import com.thy.airport.bean.airport.UpdateAirportBean;
import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.PredictiveInfos.Airports;
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
  private final FindAirportBean findAirportBean;
  private final SaveAirportBean saveAirportBean;
  private final UpdateAirportBean updateAirportBean;
  private final DeleteAirportBean deleteAirportBean;

  @Override
  public ResponsePayload<List<AirportDTO>> list() {
    return listAirportBean.list();
  }

  @Override
  public ResponsePayload<List<Airports>> listAirport(int id) {
    ResponsePayload<List<Airports>> listResponsePayload = listAirportBean.listbyCounty(id);
    return listResponsePayload;
  }

  @Override
  public ResponsePayload<AirportDTO> getAirportById(int id) {
    return findAirportBean.findById(id);
  }

  @Override
  public ResponsePayload<AirportDTO> save(AirportDTO airportDTO) {
    return saveAirportBean.save(airportDTO);
  }

  @Override
  public ResponsePayload<AirportDTO> update(AirportDTO airportDTO) {
    return updateAirportBean.update(airportDTO);
  }

  @Override
  public ResponsePayload<AirportDTO> deleteById(int id) {
    return deleteAirportBean.deleteAirportById(id);
  }
}
