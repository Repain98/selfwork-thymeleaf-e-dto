package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.dtos.AuthorDto;
import it.aulab.selfworkthymeleafedto.models.Author;
import it.aulab.selfworkthymeleafedto.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.readAll();
    }

    @GetMapping("{id}")
    public AuthorDto getAuthor(@PathVariable("id") Long id) {
        return authorService.read(id);
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody Author author) {
        return authorService.create(author);
    }

    @PutMapping("{id}")
    public AuthorDto updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.delete(id);
    }
}