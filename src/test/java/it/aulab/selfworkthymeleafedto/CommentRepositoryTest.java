package it.aulab.selfworkthymeleafedto;

import it.aulab.selfworkthymeleafedto.models.Author;
import it.aulab.selfworkthymeleafedto.models.Comment;
import it.aulab.selfworkthymeleafedto.models.Post;
import it.aulab.selfworkthymeleafedto.repositories.AuthorRepository;
import it.aulab.selfworkthymeleafedto.repositories.CommentRepository;
import it.aulab.selfworkthymeleafedto.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CommentRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    Post post;
    Comment comment;

    @BeforeEach
    void load() {
        Author author = new Author();
        author.setName("Luca");
        author.setSurname("Bianchi");
        author.setEmail("bianchiL@test.it");
        authorRepository.save(author);

        post = new Post();
        post.setTitle("Primo post");
        post.setBody("Questo è il corpo del primo post");
        post.setPublishDate("20250101");
        post.setAuthor(author);
        postRepository.save(post);

        comment = new Comment();
        comment.setEmail("commentatore@test.it");
        comment.setBody("Che bel post!");
        comment.setDate("20250102");
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Test
    void findByEmail() {
        assertThat(commentRepository.findByEmail("commentatore@test.it")).extracting("email").containsOnly("commentatore@test.it");
    }

    @Test
    void findByPost() {
        assertThat(commentRepository.findByPost(post)).extracting("email").containsOnly("commentatore@test.it");
    }

    @Test
    void findByPostId() {
        assertThat(commentRepository.findByPostId(post.getId())).extracting("email").containsOnly("commentatore@test.it");
    }

    @Test
    void commentWithSameEmail() {
        assertThat(commentRepository.commentWithSameEmail()).extracting("email").containsOnly("commentatore@test.it");
    }

    @Test
    void commentWithSameEmailNonNative() {
        assertThat(commentRepository.commentWithSameEmailNonNative()).extracting("email").containsOnly("commentatore@test.it");
    }
}