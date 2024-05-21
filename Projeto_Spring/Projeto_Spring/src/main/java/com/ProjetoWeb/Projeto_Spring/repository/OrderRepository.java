package com.ProjetoWeb.Projeto_Spring.repository;

import com.ProjetoWeb.Projeto_Spring.entitites.OrderEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntities, Long> {
}
