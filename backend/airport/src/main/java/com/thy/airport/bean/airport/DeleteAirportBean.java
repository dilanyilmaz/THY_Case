package com.thy.airport.bean.airport;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.enumaration.MessageEnum;
import com.thy.airport.enumaration.ResponseEnum;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteAirportBean extends AbstractResponsePayload {

  private final AirportRepository repo;
  private final AirportDtoMapper mapper;
  private final FindAirportBean findAirportBean;

  @Transactional
  public ResponsePayload<AirportDTO> deleteAirportById(int id) {
    ResponsePayload<AirportDTO> responsePayload = findAirportBean.findById(id);
    if (!responsePayload.getResponseEnum().equals(ResponseEnum.NOTFOUND)) {
      repo.deleteById(id);
      return setResponse(ResponseEnum.OK, MessageEnum.DELETE_SUCCESS.getMessage());
    }
    return setResponse(ResponseEnum.NOTFOUND, MessageEnum.NOT_FOUND);
  }
}
