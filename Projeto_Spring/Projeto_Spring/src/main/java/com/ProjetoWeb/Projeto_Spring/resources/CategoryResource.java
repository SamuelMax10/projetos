package com.ProjetoWeb.Projeto_Spring.resources;

import com.ProjetoWeb.Projeto_Spring.entitites.CategoryEntities;
import com.ProjetoWeb.Projeto_Spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryEntities>> findAll() {
        List<CategoryEntities> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntities> findById(@PathVariable Long id) {
        CategoryEntities obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
