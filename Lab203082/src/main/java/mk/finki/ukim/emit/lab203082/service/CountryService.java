package mk.finki.ukim.emit.lab203082.service;

import mk.finki.ukim.emit.lab203082.model.Country;
import mk.finki.ukim.emit.lab203082.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAllCountries();

    Optional<Country> findCountryById(Long id);

    Optional<Country> addCountry(CountryDto countryDto);


}
