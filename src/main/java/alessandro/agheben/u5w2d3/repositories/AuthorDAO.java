package alessandro.agheben.u5w2d3.repositories;

import alessandro.agheben.u5w2d3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorDAO extends JpaRepository<Author,Long> {

    Optional<Author> findByEmail(String email);


}
