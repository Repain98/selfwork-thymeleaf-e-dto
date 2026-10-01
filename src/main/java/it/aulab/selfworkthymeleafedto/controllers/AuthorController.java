package it.aulab.selfworkthymeleafedto.controllers;

import it.aulab.selfworkthymeleafedto.models.Author;
import it.aulab.selfworkthymeleafedto.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public String index(Model viewModel) {
        viewModel.addAttribute("title", "Authors");
        viewModel.addAttribute("authors", authorService.readAll());
        return "authors";
    }

    @GetMapping("create")
    public String createAuthorView(Model viewModel) {
        viewModel.addAttribute("title", "Create Author");
        viewModel.addAttribute("author", new Author());
        return "createAuthor";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorService.create(author);
        return "redirect:/authors";
    }

    @GetMapping("{id}")
    public String authorDetail(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("title", "Author Detail");
        viewModel.addAttribute("author", authorService.read(id));
        return "authorDetail";
    }

    @GetMapping("{id}/edit")
    public String editAuthorView(Model viewModel, @PathVariable("id") Long id) {
        viewModel.addAttribute("title", "Edit Author");
        viewModel.addAttribute("author", authorService.read(id));
        return "editAuthor";
    }

    @PostMapping("{id}/update")
    public String updateAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author author) {
        authorService.update(id, author);
        return "redirect:/authors";
    }

    @PostMapping("{id}/delete")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }
}
