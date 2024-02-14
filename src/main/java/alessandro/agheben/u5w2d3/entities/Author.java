package alessandro.agheben.u5w2d3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String avatarUrl;

    public Author(String name, String surname, String email, LocalDate dateOfBirth, String avatarUrl) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.avatarUrl = avatarUrl;
    }
}
