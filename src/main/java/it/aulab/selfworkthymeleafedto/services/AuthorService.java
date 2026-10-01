package it.aulab.selfworkthymeleafedto.services;

import it.aulab.selfworkthymeleafedto.dtos.AuthorDto;
import it.aulab.selfworkthymeleafedto.models.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> readAll();

    AuthorDto read(Long id);

    List<AuthorDto> read(String mail);

    List<AuthorDto> read(String firstname, String lastname);

    AuthorDto create(Author author);

    AuthorDto update(Long id, Author author);

    void delete(Long id);
}