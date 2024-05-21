package com.ProjetoWeb.Projeto_Spring.repository;

import com.ProjetoWeb.Projeto_Spring.entitites.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntities, Long> {

}
