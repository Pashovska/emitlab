package mk.finki.ukim.emit.lab203082.web;

import mk.finki.ukim.emit.lab203082.model.Author;
import mk.finki.ukim.emit.lab203082.model.dto.AuthorDto;
import mk.finki.ukim.emit.lab203082.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {

        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long authorId) {
        return this.authorService.findAuthorById(authorId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto) {
        return this.authorService.saveAuthor(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
