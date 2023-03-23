package mk.finki.ukim.emit.lab203082.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId")
    private Long id;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "countryContinent")
    private String countryContinent;

    public Country(String countryName, String countryContinent) {
        this.countryName = countryName;
        this.countryContinent = countryContinent;
    }


}
