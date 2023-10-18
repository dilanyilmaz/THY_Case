package com.thy.airport.bean.country;

import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.core.AbstractResponsePayload;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.entity.Airport;
import com.thy.airport.entity.Country;
import com.thy.airport.mapper.CountryDtoMapper;
import com.thy.airport.repository.CountryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListCountryBean extends AbstractResponsePayload {
    private final CountryRepository repo;
    private final CountryDtoMapper mapper;

    public ResponsePayload<List<CountryDTO>> list(){
      return setResponse(mapper.mapList((List<Country>) repo.findAll()));
    }
}
