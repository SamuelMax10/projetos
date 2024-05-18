package com.ProjetoWeb.Projeto_Spring.config;

import com.ProjetoWeb.Projeto_Spring.entities.User;
import com.ProjetoWeb.Projeto_Spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u = new User(null, "Samuel Max", "samuel@gmail.com", "4002-8022", "12345");
        User u1 = new User(null, "Sabrina Izabela", "sabrina@gmail.com", "7070-7080", "54321");

        userRepository.saveAll(Arrays.asList(u, u1));
    }
}
