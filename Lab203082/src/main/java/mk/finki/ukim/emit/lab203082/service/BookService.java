package mk.finki.ukim.emit.lab203082.service;

import mk.finki.ukim.emit.lab203082.model.Book;
import mk.finki.ukim.emit.lab203082.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findBookById(Long id);

    Page<Book> findAllWithPagination(Pageable pageable);

    Optional<Book> saveBook(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> changeAvailability(Long id);

}
