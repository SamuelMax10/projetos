package com.ProjetoWeb.Projeto_Spring.resources;

import com.ProjetoWeb.Projeto_Spring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1, "Samuel", "samuel@gmail.com", "4002-8922", "12345");
        return ResponseEntity.ok().body(u);
    }
}
