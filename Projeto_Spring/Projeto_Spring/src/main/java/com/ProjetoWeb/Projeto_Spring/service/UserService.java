package com.ProjetoWeb.Projeto_Spring.service;

import com.ProjetoWeb.Projeto_Spring.entitites.UserEntities;
import com.ProjetoWeb.Projeto_Spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserEntities> findAll(){
        return repository.findAll();
    }

    public UserEntities findById(Long id){
        Optional<UserEntities> obj = repository.findById(id);
        return obj.get();
    }
}
