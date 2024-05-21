package com.ProjetoWeb.Projeto_Spring.resources;

import com.ProjetoWeb.Projeto_Spring.entitites.OrderEntities;
import com.ProjetoWeb.Projeto_Spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderResources {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderEntities>> finAll() {
        List<OrderEntities> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderEntities> finById(@PathVariable Long id){
        OrderEntities obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
