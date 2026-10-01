package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.models.Comment;
import it.aulab.selfworkthymeleafedto.services.CommentService;
import it.aulab.selfworkthymeleafedto.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @GetMapping
    public String index(Model viewModel) {
        viewModel.addAttribute("title", "Comments");
        viewModel.addAttribute("comments", commentService.readAll());
        return "comments";
    }

    @GetMapping("create")
    public String createCommentView(Model viewModel) {
        viewModel.addAttribute("title", "Create Comment");
        viewModel.addAttribute("comment", new Comment());
        viewModel.addAttribute("posts", postService.readAll());
        return "createComment";
    }

    @PostMapping
    public String createComment(@ModelAttribute("comment") Comment comment) {
        commentService.create(comment);
        return "redirect:/comments";
    }

    @GetMapping("{id}/edit")
    public String editCommentView(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("title", "Edit Comment");
        viewModel.addAttribute("comment", commentService.read(id));
        viewModel.addAttribute("posts", postService.readAll());
        return "editComment";
    }

    @PostMapping("{id}/update")
    public String updateComment(@PathVariable("id") Long id, @ModelAttribute("comment") Comment comment) {
        commentService.update(id, comment);
        return "redirect:/comments";
    }

    @PostMapping("{id}/delete")
    public String deleteComment(@PathVariable("id") Long id) {
        commentService.delete(id);
        return "redirect:/comments";
    }
}
