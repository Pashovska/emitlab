package mk.finki.ukim.emit.lab203082.model.dto;

import lombok.Data;

@Data
public class CountryDto {

    private String countryName;

    private String continent;

    public CountryDto(String countryName, String continent) {
        this.countryName = countryName;
        this.continent = continent;
    }

    public CountryDto() {
    }
}
