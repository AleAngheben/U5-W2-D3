package alessandro.agheben.u5w2d3.payloads;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private String avatarUrl;
}
