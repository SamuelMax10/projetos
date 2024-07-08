package com.workshopmongo.demo.config;

import com.workshopmongo.demo.domain.Post;
import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.dto.AuthorDto;
import com.workshopmongo.demo.dto.CommentDto;
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

        var samuel = new User(null, "Samuel Max", "samuel@gmail.com");
        var sabrina = new User(null, "Sabrina Izabela", "sabrina@gmail.com");
        var leidynara = new User(null, "Leidynara Breder", "leidynara@gmail.com");

        userRepository.saveAll(Arrays.asList(samuel, sabrina, leidynara));

        var post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu Viagem", "Vou viajar para o Cabo Frio!!!", new AuthorDto( samuel));
        var post2 = new Post(null, sdf.parse("25/03/2024"), "Bom dia", "Me arrumando para ir a praia :)", new AuthorDto(samuel));

        var c1 = new CommentDto("Boa viagem maninho", sdf.parse("21/07/2024"),new AuthorDto(sabrina));
        var c2 = new CommentDto("Boa viagem meu amor", sdf.parse("22/07/2024"),new AuthorDto(leidynara));
        var c3 = new CommentDto("Use protetor solar kkkkk", sdf.parse("22/07/2024"),new AuthorDto(sabrina));

        post1.getComments().addAll(Arrays.asList(c1,c2));

        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        samuel.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(samuel);
    }
}
