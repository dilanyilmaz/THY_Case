package com.thy.airport.service.impl;

import com.thy.airport.bean.country.ListCountryBean;
import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.core.ResponsePayload;
import com.thy.airport.service.CountryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountryServiceImpl implements CountryService {
  private final ListCountryBean listCountryBean;
  @Override
  public ResponsePayload<List<CountryDTO>> list() {
    return listCountryBean.list();
  }
}
