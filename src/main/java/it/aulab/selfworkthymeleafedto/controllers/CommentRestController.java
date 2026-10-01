package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.dtos.CommentDto;
import it.aulab.selfworkthymeleafedto.models.Comment;
import it.aulab.selfworkthymeleafedto.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentDto> getAllComments() {
        return commentService.readAll();
    }

    @GetMapping("{id}")
    public CommentDto getComment(@PathVariable("id") Long id) {
        return commentService.read(id);
    }

    @PostMapping
    public CommentDto createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @PutMapping("{id}")
    public CommentDto updateComment(@PathVariable("id") Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.delete(id);
    }
}
