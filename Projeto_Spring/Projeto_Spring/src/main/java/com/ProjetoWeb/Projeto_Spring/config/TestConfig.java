package com.ProjetoWeb.Projeto_Spring.config;

import com.ProjetoWeb.Projeto_Spring.model.*;
import com.ProjetoWeb.Projeto_Spring.model.enums.OrderStatus;
import com.ProjetoWeb.Projeto_Spring.repository.*;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        var c1 = new Category(null, "Eletronics");
        var c2 = new Category(null, "Books");
        var c3 = new Category(null, "Computers");

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 100.0, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 3000.0, "");
        var p3 = new Product(null, "Monitor LG 24 polegadas", "Nam eleifend maximus tortor, at mollis.", 660.0, "");
        var p4 = new Product(null, "Teclado mecanico Redragon", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 200.0, "");

        categoryRepository.saveAll((Arrays.asList(c1, c2, c3)));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        var u1 = new User(null, "Samuel Max", "samuel@gmail.com", "4002-8022", "12345");
        var u2 = new User(null, "Sabrina Izabela", "sabrina@gmail.com", "7070-7080", "54321");

        var o1= new Order(null, Instant.parse("2024-05-20T20:00:00Z"), OrderStatus.PAID, u1);
        var o2 = new Order(null, Instant.parse("2024-05-20T20:10:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        var o3 = new Order(null, Instant.parse("2024-05-20T21:30:00Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        var oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        var oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        var oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        var oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
    }
}
