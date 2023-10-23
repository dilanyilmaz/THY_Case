package com.thy.airport.bean.airport;

import com.thy.airport.dto.AirportDTO;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Airport;
import com.thy.airport.enumaration.MessageEnum;
import com.thy.airport.enumaration.ResponseEnum;
import com.thy.airport.mapper.AirportDtoMapper;
import com.thy.airport.repository.AirportRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindAirportBean extends AbstractResponsePayload {
  private final AirportRepository repo;
  private final AirportDtoMapper mapper;
  public ResponsePayload<AirportDTO> findById(int id) {
    Optional<Airport> byId = repo.findById(id);
    if (byId.isPresent()) {
      return setResponse(mapper.map(byId.get()));
    }
    return setResponse(ResponseEnum.NOTFOUND, MessageEnum.NOT_FOUND.getMessage());
  }
}
