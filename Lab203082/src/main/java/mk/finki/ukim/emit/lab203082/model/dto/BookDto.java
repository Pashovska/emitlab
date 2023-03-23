package mk.finki.ukim.emit.lab203082.model.dto;

import lombok.Data;
import mk.finki.ukim.emit.lab203082.model.enumerations.Category;

@Data
public class BookDto {
    private String bookName;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto(String bookName, Category category, Long author, Integer availableCopies) {
        this.bookName = bookName;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
