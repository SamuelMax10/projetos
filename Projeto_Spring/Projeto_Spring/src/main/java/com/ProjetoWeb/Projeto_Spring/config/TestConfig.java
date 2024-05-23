package com.ProjetoWeb.Projeto_Spring.config;

import com.ProjetoWeb.Projeto_Spring.model.Category;
import com.ProjetoWeb.Projeto_Spring.model.Order;
import com.ProjetoWeb.Projeto_Spring.model.Product;
import com.ProjetoWeb.Projeto_Spring.model.User;
import com.ProjetoWeb.Projeto_Spring.model.enums.OrderStatus;
import com.ProjetoWeb.Projeto_Spring.repository.CategoryRepository;
import com.ProjetoWeb.Projeto_Spring.repository.OrderRepository;
import com.ProjetoWeb.Projeto_Spring.repository.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        var u = new User(null, "Samuel Max", "samuel@gmail.com", "4002-8022", "12345");
        var u1 = new User(null, "Sabrina Izabela", "sabrina@gmail.com", "7070-7080", "54321");

        var o = new Order(null, Instant.parse("2024-05-20T20:00:00Z"), OrderStatus.PAID, u);
        var o1 = new Order(null, Instant.parse("2024-05-20T20:10:00Z"), OrderStatus.WAITING_PAYMENT, u1);
        var o3 = new Order(null, Instant.parse("2024-05-20T21:30:00Z"), OrderStatus.WAITING_PAYMENT, u);

        var c = new Category(null,"Eletronics");
        var c1 = new Category(null,"Books");
        var c2 = new Category(null,"Computers");

        var p = new Product(null,"The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur." ,100.0,"");
        var p1 = new Product(null,"Smart TV", "Nulla eu imperdiet purus. Maecenas ante." ,3000.0,"");
        var p2 = new Product(null,"Monitor LG 24 polegadas", "Nam eleifend maximus tortor, at mollis." ,660.0,"");
        var p3 = new Product(null,"Teclado mecanico Redragon", "Donec aliquet odio ac rhoncus cursus." ,1200.0,"");
        var p4 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus." ,200.0,"");

        userRepository.saveAll(Arrays.asList(u, u1));
        orderRepository.saveAll(Arrays.asList(o, o1, o3));
        categoryRepository.saveAll((Arrays.asList(c,c1,c2)));
        productRepository.saveAll(Arrays.asList(p,p1,p2,p3,p4));
    }
}
