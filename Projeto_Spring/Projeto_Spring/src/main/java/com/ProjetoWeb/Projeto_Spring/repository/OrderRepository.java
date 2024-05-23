package com.ProjetoWeb.Projeto_Spring.repository;

import com.ProjetoWeb.Projeto_Spring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
