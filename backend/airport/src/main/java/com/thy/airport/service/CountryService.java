package com.thy.airport.service;

import com.thy.airport.dto.CountryDTO;
import com.thy.airport.dto.core.ResponsePayload;
import java.util.List;

public interface CountryService {
  ResponsePayload<List<CountryDTO>> list();
}
