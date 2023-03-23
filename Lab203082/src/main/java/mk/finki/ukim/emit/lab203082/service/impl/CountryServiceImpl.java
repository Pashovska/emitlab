package mk.finki.ukim.emit.lab203082.service.impl;

import mk.finki.ukim.emit.lab203082.model.Country;
import mk.finki.ukim.emit.lab203082.model.dto.CountryDto;
import mk.finki.ukim.emit.lab203082.repository.CountryRepository;
import mk.finki.ukim.emit.lab203082.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findCountryById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> addCountry(CountryDto countryDto) {
        Country country = new Country(countryDto.getCountryName(), countryDto.getContinent());
        return Optional.of(this.countryRepository.save(country));
    }
}
