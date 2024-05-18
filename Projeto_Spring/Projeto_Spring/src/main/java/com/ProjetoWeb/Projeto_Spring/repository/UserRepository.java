package com.ProjetoWeb.Projeto_Spring.repository;

import com.ProjetoWeb.Projeto_Spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
