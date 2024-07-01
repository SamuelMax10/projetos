package com.workshopmongo.demo.config;

import com.workshopmongo.demo.domain.Post;
import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.repository.PostRepository;
import com.workshopmongo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Array;
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

        var post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu Viagem", "Vou viajar para o Cabo Frio!!!", samuel);

        var post2 = new Post(null, sdf.parse("25/03/2024"), "Bom dia", "Me arrumando para ir a praia :)", samuel);

        userRepository.saveAll(Arrays.asList(samuel, sabrina, leidynara));

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
