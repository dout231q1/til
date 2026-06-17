package com.example.livrosapi.dto;

import com.example.livrosapi.entity.Livros;

import java.time.Year;

public record LivrosResponseDTO(Long id, String titulo, String autor, String isbn, Year anoPublicacao){
    public LivrosResponseDTO(Livros livro){
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getAnoPublicacao());
    }
}

