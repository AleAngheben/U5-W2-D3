package alessandro.agheben.u5w2d3.controllers;

import alessandro.agheben.u5w2d3.entities.Post;
import alessandro.agheben.u5w2d3.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    public List<Post> getBlogs() {
        return postService.getPosts();
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post postPost(@RequestBody Post body) {
        return postService.save(body);
    }

    @GetMapping("/{id}")
    public Post getById(int id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public Post updateById(@PathVariable int id, @RequestBody Post body) {
        return postService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.findByIdAndDelete(id);
    }


}
