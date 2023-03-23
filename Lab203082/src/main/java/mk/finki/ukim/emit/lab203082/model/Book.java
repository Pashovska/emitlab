package mk.finki.ukim.emit.lab203082.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.finki.ukim.emit.lab203082.model.enumerations.Category;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    @Column(name = "available_copies")
    private Integer availableCopies;

    @Column(name = "book_availability")
    private boolean isAvailable;

    public Book(String name, Category category, Author author, Integer availableCopies, boolean isAvailable) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
        this.isAvailable = isAvailable;
    }
}
