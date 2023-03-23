package mk.finki.ukim.emit.lab203082.service.impl;

import mk.finki.ukim.emit.lab203082.model.Author;
import mk.finki.ukim.emit.lab203082.model.Book;
import mk.finki.ukim.emit.lab203082.model.dto.BookDto;
import mk.finki.ukim.emit.lab203082.model.enumerations.Category;
import mk.finki.ukim.emit.lab203082.model.exceptions.AuthorNotFoundException;
import mk.finki.ukim.emit.lab203082.model.exceptions.BookNotFoundException;
import mk.finki.ukim.emit.lab203082.repository.AuthorRepository;
import mk.finki.ukim.emit.lab203082.repository.BookRepository;
import mk.finki.ukim.emit.lab203082.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> saveBook(BookDto bookDto) {

        Category bookCategory = Category.valueOf(bookDto.getCategory().toString());

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        Book book = new Book(bookDto.getBookName(), bookCategory, author, bookDto.getAvailableCopies(), true);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);
        book.setCategory(Category.valueOf(bookDto.getCategory().toString()));
        book.setName(bookDto.getBookName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {

        this.bookRepository.deleteById(id);

    }

    @Override
    public Optional<Book> changeAvailability(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies > 0)
        {
            book.setAvailableCopies(--availableCopies);

            if(availableCopies == 0) {
                book.setAvailable(false);
            }
        }
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
