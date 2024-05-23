package com.ProjetoWeb.Projeto_Spring.repository;

import com.ProjetoWeb.Projeto_Spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
