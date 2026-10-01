package it.aulab.selfworkthymeleafedto.services;

import it.aulab.selfworkthymeleafedto.dtos.CommentDto;
import it.aulab.selfworkthymeleafedto.models.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> readAll();

    CommentDto read(Long id);

    List<CommentDto> readByPost(Long postId);

    CommentDto create(Comment comment);

    CommentDto update(Long id, Comment comment);

    void delete(Long id);
}
