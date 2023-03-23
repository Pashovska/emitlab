package mk.finki.ukim.emit.lab203082.service.impl;

import mk.finki.ukim.emit.lab203082.model.Author;
import mk.finki.ukim.emit.lab203082.model.Country;
import mk.finki.ukim.emit.lab203082.model.dto.AuthorDto;
import mk.finki.ukim.emit.lab203082.model.exceptions.CountryNotFoundException;
import mk.finki.ukim.emit.lab203082.repository.AuthorRepository;
import mk.finki.ukim.emit.lab203082.repository.CountryRepository;
import mk.finki.ukim.emit.lab203082.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthorById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> saveAuthor(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getAuthorCountryId())
                .orElseThrow(() -> new CountryNotFoundException(authorDto.getAuthorCountryId()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        return Optional.of(this.authorRepository.save(author));
    }
}
