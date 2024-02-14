package alessandro.agheben.u5w2d3.repositories;

import alessandro.agheben.u5w2d3.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostDAO extends JpaRepository<Post,Long> {

    Optional<Post> findByTitle(String title);

    Page<Post> findByCategory(String category, Pageable pageable);

    Page<Post> findByTimeToRead(int timeToRead, Pageable pageable);

    Page<Post> findByTimeToReadAndCategory(int timeToRead, String category, Pageable pageable);

}
