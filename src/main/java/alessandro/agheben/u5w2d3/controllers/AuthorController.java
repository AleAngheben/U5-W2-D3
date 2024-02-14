package alessandro.agheben.u5w2d3.controllers;

import alessandro.agheben.u5w2d3.entities.Author;
import alessandro.agheben.u5w2d3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Validated
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String id) {
        return authorService.getAuthors(page, size, id);
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable long id) {
        return authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author getByIdAndUpdate(@PathVariable long id, @RequestBody Author author) {

        return authorService.findByIdAndUpdate(id, author);
    }

    @DeleteMapping("/{id}")
    public void getByIdAndDelete(@PathVariable long id) {
        authorService.findByIdAndDelete(id);
    }

}
