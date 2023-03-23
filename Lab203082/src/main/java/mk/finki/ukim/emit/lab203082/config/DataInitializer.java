package mk.finki.ukim.emit.lab203082.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.emit.lab203082.model.dto.AuthorDto;
import mk.finki.ukim.emit.lab203082.model.dto.BookDto;
import mk.finki.ukim.emit.lab203082.model.dto.CountryDto;
import mk.finki.ukim.emit.lab203082.model.enumerations.Category;
import mk.finki.ukim.emit.lab203082.service.AuthorService;
import mk.finki.ukim.emit.lab203082.service.BookService;
import mk.finki.ukim.emit.lab203082.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    private Category randomizeEventType(int i) {
        if (i % 3 == 0) return Category.BIOGRAPHY;
        else if (i % 3 == 1) return Category.THRILER;
        return Category.CLASSICS;
    }

    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.countryService.addCountry(new CountryDto("Country" + i, "Continent" + i));
            this.authorService.saveAuthor(new AuthorDto("Author" + i, "Surname", this.countryService.findAllCountries().get((i - 1) % 5).getId()));
        }

        for (int i = 1; i < 11; i++) {
            this.bookService.saveBook(new BookDto("Book name" + i, this.randomizeEventType(i), this.authorService.findAllAuthors().get((i - 1) % 5).getId(), i + 1));
        }
    }
}
