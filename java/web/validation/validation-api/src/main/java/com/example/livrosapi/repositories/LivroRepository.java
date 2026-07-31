package com.example.livrosapi.repositories;

import com.example.livrosapi.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
