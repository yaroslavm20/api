package me.malofienko.controller;

import jakarta.validation.Valid;
import me.malofienko.dto.PostCreateOrUpdateDTO;
import me.malofienko.model.Post;
import me.malofienko.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post create(@Valid @RequestBody PostCreateOrUpdateDTO postDTO) {
        Post post = new Post(postDTO.getTitle(), postDTO.getContent());

        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @Valid @RequestBody PostCreateOrUpdateDTO postDTO) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost == null) {
            return ResponseEntity.notFound().build();
        }

        existingPost.setTitle(postDTO.getTitle());
        existingPost.setContent(postDTO.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());

        Post updatedPost = postRepository.save(existingPost);

        return ResponseEntity.ok(updatedPost);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
