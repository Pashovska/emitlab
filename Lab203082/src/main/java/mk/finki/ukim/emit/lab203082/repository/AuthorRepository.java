package mk.finki.ukim.emit.lab203082.repository;

import mk.finki.ukim.emit.lab203082.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
