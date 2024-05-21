package com.ProjetoWeb.Projeto_Spring.config;

import com.ProjetoWeb.Projeto_Spring.entitites.OrderEntities;
import com.ProjetoWeb.Projeto_Spring.entitites.UserEntities;
import com.ProjetoWeb.Projeto_Spring.entitites.enums.OrderStatus;
import com.ProjetoWeb.Projeto_Spring.repository.OrderRepository;
import com.ProjetoWeb.Projeto_Spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        var u = new UserEntities(null, "Samuel Max", "samuel@gmail.com", "4002-8022", "12345");
        var u1 = new UserEntities(null, "Sabrina Izabela", "sabrina@gmail.com", "7070-7080", "54321");

        var o = new OrderEntities(null, Instant.parse("2024-05-20T20:00:00Z"), OrderStatus.PAID, u);
        var o1 = new OrderEntities(null, Instant.parse("2024-05-20T20:10:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        var o3 = new OrderEntities(null, Instant.parse("2024-05-20T21:30:00Z"), OrderStatus.WAITING_PAYMENT, u);

        userRepository.saveAll(Arrays.asList(u, u1));
        orderRepository.saveAll(Arrays.asList(o, o1, o3));
    }
}
