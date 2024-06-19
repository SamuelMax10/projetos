package com.workshopmongo.demo.config;

import com.workshopmongo.demo.domain.User;
import com.workshopmongo.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User samuel = new User(null, "Samuel Max", "samuel@gmail.com");
        User sabrina = new User(null, "Sabrina Izabela", "sabrina@gmail.com");
        User leidynara = new User(null, "Leidynara Breder", "leidynara@gmail.com");

        userRepository.saveAll(Arrays.asList(samuel, sabrina, leidynara));
    }
}
