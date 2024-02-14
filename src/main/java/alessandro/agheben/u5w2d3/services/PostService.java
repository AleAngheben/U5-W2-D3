package alessandro.agheben.u5w2d3.services;

import alessandro.agheben.u5w2d3.entities.Author;
import alessandro.agheben.u5w2d3.entities.Post;
import alessandro.agheben.u5w2d3.exceptions.BadRequestException;
import alessandro.agheben.u5w2d3.exceptions.NoFoundException;
import alessandro.agheben.u5w2d3.payloads.PostPayload;
import alessandro.agheben.u5w2d3.repositories.AuthorDAO;
import alessandro.agheben.u5w2d3.repositories.PostDAO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Getter
public class PostService {

@Autowired
    PostDAO postDAO;
@Autowired
AuthorService authorService;

    public Page<Post> getPosts(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));
        return postDAO.findAll(pageable);
    }

    public Page<Post> getByCategory(String category, int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return postDAO.findByCategory(category, pageable);
    }

    public Page<Post> getByTimeToRead(int timeToRead, int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(orderBy));
        return postDAO.findByTimeToRead(timeToRead, pageable);
    }

    public Page<Post> getByReadingTimeAndCategory(int readingTime, String category, int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page,size,Sort.by(orderBy));
        return postDAO.findByTimeToReadAndCategory(readingTime,category,pageable);
    }




    public Post findById(int id) {
        Post found = null;
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id) {
                found = posts.get(i);
            }
        }
        if(found == null) throw new NoFoundException(id);
        return found;
    }

    public Post findByIdAndUpdate(int id, Post body) {
        Post found = null;
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == id) {
                found = posts.get(i);
                found.setCategory(body.getCategory());
                found.setTitle(body.getTitle());
                found.setContent(body.getContent());
                found.setTimeToRead(body.getTimeToRead());
            }
        }
        if (found == null) throw new NoFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Post found = this.findById(id);
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == found.getId()) {
                posts.remove(found);
            }
        }
    }

}
