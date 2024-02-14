package alessandro.agheben.u5w2d3.payloads;

import alessandro.agheben.u5w2d3.entities.Author;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class PostPayload {
    private String category;
    private String title;
    private String coverUrl;
    private String content;
    private int timeToRead;
    private Author authorUrl;
}
