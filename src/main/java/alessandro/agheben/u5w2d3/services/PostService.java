package alessandro.agheben.u5w2d3.services;

import alessandro.agheben.u5w2d3.entities.Post;
import alessandro.agheben.u5w2d3.exceptions.NoFoundException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Getter
public class PostService {


    private List<Post> posts = new ArrayList<>();

    public Post save(Post body){
        Random rnd = new Random();
        body.setId(rnd.nextInt(1,3000));
        body.setTimeToRead(rnd.nextInt(1,10));
        this.posts.add(body);
        return body;
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
