package mk.finki.ukim.emit.lab203082.repository;

import mk.finki.ukim.emit.lab203082.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
