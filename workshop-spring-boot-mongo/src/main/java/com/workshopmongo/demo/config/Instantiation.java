package com.workshopmongo.demo.config;

import com.workshopmongo.demo.domain.Post;
import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.dto.AuthorDto;
import com.workshopmongo.demo.repository.PostRepository;
import com.workshopmongo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        postRepository.deleteAll();

        User samuel = new User(null, "Samuel Max", "samuel@gmail.com");
        User sabrina = new User(null, "Sabrina Izabela", "sabrina@gmail.com");
        User leidynara = new User(null, "Leidynara Breder", "leidynara@gmail.com");

        userRepository.saveAll(Arrays.asList(samuel, sabrina, leidynara));

        var post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu Viagem", "Vou viajar para o Cabo Frio!!!", new AuthorDto( samuel));
        var post2 = new Post(null, sdf.parse("25/03/2024"), "Bom dia", "Me arrumando para ir a praia :)", new AuthorDto(samuel));

        postRepository.saveAll(Arrays.asList(post1,post2));

        samuel.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(samuel);
    }
}
