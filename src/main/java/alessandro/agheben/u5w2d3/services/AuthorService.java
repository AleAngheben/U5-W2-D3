package alessandro.agheben.u5w2d3.services;

import alessandro.agheben.u5w2d3.entities.Author;
import alessandro.agheben.u5w2d3.exceptions.NoFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Getter
public class AuthorService {

    private List<Author> authors = new ArrayList<>();


    public Author save(Author body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 3000));
        LocalDate date = LocalDate.of(random.nextInt(1950, 2000), random.nextInt(1, 12), random.nextInt(1, 30));

        body.setDateOfBirth(date);

        this.authors.add(body);
        return body;
    }

    public Author findById(long id) {

        Author found = null;

        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId() == id) {
                found = authors.get(i);
            }
        }
        if (found == null) throw new NoFoundException(id);

        return found;
    }

    public Author findByIdAndUpdate(long id, Author body) {
        Author found = this.findById(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setDateOfBirth(body.getDateOfBirth());
        found.setAvatarUrl(body.getAvatarUrl());

        return body;
    }

    public void findByIdAndDelete(long id) {

        Iterator<Author> iterator = this.authors.iterator();

        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }


    }

}
