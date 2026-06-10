package com.example.livrosapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
