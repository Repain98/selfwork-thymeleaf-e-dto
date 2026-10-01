package it.aulab.selfworkthymeleafedto.services;

import it.aulab.selfworkthymeleafedto.dtos.PostDto;
import it.aulab.selfworkthymeleafedto.models.Post;

import java.util.List;

public interface PostService {
    List<PostDto> readAll();

    PostDto read(Long id);

    PostDto create(Post post);

    PostDto update(Long id, Post post);

    void delete(Long id);
}
