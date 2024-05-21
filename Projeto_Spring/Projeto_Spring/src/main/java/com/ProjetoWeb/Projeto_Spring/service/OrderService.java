package com.ProjetoWeb.Projeto_Spring.service;

import com.ProjetoWeb.Projeto_Spring.entitites.OrderEntities;
import com.ProjetoWeb.Projeto_Spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderEntities> findAll(){
        return repository.findAll();
    }
    public OrderEntities findById(Long id){
        Optional<OrderEntities> obj = repository.findById(id);
        return obj.get();
    }

}
