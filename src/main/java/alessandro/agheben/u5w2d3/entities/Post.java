package alessandro.agheben.u5w2d3.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category;

    private String title;

    private String coverUrl;

    private String content;


    private int timeToRead;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Post(String category, String title, String coverUrl, String content, int timeToRead, Author author) {
        this.category = category;
        this.title = title;
        this.coverUrl = coverUrl;
        this.content = content;
        this.timeToRead = timeToRead;
        this.author = author;
    }
}
