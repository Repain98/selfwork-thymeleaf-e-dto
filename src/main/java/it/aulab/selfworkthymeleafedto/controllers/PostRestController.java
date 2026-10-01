package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.dtos.PostDto;
import it.aulab.selfworkthymeleafedto.models.Post;
import it.aulab.selfworkthymeleafedto.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.readAll();
    }

    @GetMapping("{id}")
    public PostDto getPost(@PathVariable("id") Long id) {
        return postService.read(id);
    }

    @PostMapping
    public PostDto createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("{id}")
    public PostDto updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id) {
        postService.delete(id);
    }
}
