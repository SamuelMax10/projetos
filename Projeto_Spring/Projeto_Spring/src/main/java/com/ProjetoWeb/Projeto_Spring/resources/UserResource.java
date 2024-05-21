package com.ProjetoWeb.Projeto_Spring.resources;

import com.ProjetoWeb.Projeto_Spring.entitites.UserEntities;
import com.ProjetoWeb.Projeto_Spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntities>> findAll() {
        List<UserEntities> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntities> findById(@PathVariable Long id) {
        UserEntities obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
