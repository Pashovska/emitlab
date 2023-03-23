package mk.finki.ukim.emit.lab203082.service;

import mk.finki.ukim.emit.lab203082.model.Author;
import mk.finki.ukim.emit.lab203082.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAllAuthors();

    Optional<Author> findAuthorById(Long id);

    Optional<Author> saveAuthor(AuthorDto authorDto);

}
