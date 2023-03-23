package mk.finki.ukim.emit.lab203082.model.dto;

import lombok.Data;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Long authorCountryId;

    public AuthorDto(String name, String surname, Long authorCountryId) {
        this.name = name;
        this.surname = surname;
        this.authorCountryId = authorCountryId;
    }

    public AuthorDto() {
    }
}
