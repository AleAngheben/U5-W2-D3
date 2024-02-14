package alessandro.agheben.u5w2d3.services;

import alessandro.agheben.u5w2d3.entities.Author;
import alessandro.agheben.u5w2d3.exceptions.BadRequestException;
import alessandro.agheben.u5w2d3.exceptions.NoFoundException;
import alessandro.agheben.u5w2d3.repositories.AuthorDAO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Getter
public class AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    public Page<Author> getAuthors(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorDAO.findAll(pageable);
    }

    public Author save(Author author) {
        Random random = new Random();
        authorDAO.findByEmail(author.getEmail()).ifPresent(author1 -> {
            throw new BadRequestException("Email " + author.getEmail() + " già in uso !");
        });

        author.setAvatarUrl("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname());
        author.setDateOfBirth(LocalDate.of(random.nextInt(1940, 2010), random.nextInt(1, 13), random.nextInt(1, 29)));


        return authorDAO.save(author);
    }

    public Author findById(long id) {
        return authorDAO.findById(id).orElseThrow(()->new NoFoundException(id));
    }

    public Author findByIdAndUpdate(long id, Author body) {
        Author found = this.findById(id);

        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setDateOfBirth(body.getDateOfBirth());
        found.setAvatarUrl(body.getAvatarUrl());

        return authorDAO.save(body);
    }

    public void findByIdAndDelete(long id) {

        Author found = this.findById(id);
        authorDAO.delete(found);

    }

}
