package com.ProjetoWeb.Projeto_Spring.service;

import com.ProjetoWeb.Projeto_Spring.entitites.CategoryEntities;
import com.ProjetoWeb.Projeto_Spring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryEntities> findAll() {
        return repository.findAll();
    }

    public CategoryEntities findById(Long id) {
        Optional<CategoryEntities> obj = repository.findById(id);
        return obj.get();
    }
}
