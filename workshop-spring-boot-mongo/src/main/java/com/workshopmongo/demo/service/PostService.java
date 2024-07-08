package com.workshopmongo.demo.service;

import com.workshopmongo.demo.domain.Post;
import com.workshopmongo.demo.repository.PostRepository;
import com.workshopmongo.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;

@Service
public class PostService {

    @Autowired
    public PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }
}
