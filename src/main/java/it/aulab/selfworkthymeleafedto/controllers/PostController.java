package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.models.Post;
import it.aulab.selfworkthymeleafedto.services.AuthorService;
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
@RequestMapping("/posts")
public class PostController {

    @Autowired
    AuthorService authorService;

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @GetMapping
    public String index(Model viewModel) {
        viewModel.addAttribute("title", "Posts");
        viewModel.addAttribute("posts", postService.readAll());
        return "posts";
    }

    @GetMapping("create")
    public String createPostView(Model viewModel) {
        viewModel.addAttribute("title", "Create Post");
        viewModel.addAttribute("post", new Post());
        viewModel.addAttribute("authors", authorService.readAll());
        return "createPost";
    }

    @PostMapping
    public String createPost(@ModelAttribute("post") Post post) {
        postService.create(post);
        return "redirect:/posts";
    }

    @GetMapping("{id}")
    public String postDetail(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("title", "Post Detail");
        viewModel.addAttribute("post", postService.read(id));
        viewModel.addAttribute("comments", commentService.readByPost(id));
        return "postDetail";
    }

    @GetMapping("{id}/edit")
    public String editPostView(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("title", "Edit Post");
        viewModel.addAttribute("post", postService.read(id));
        viewModel.addAttribute("authors", authorService.readAll());
        return "editPost";
    }

    @PostMapping("{id}/update")
    public String updatePost(@PathVariable("id") Long id, @ModelAttribute("post") Post post) {
        postService.update(id, post);
        return "redirect:/posts";
    }

    @PostMapping("{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postService.delete(id);
        return "redirect:/posts";
    }
}
