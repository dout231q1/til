package com.example.livrosapi.repository;

import com.example.livrosapi.entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
