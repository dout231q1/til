package com.example.livrosapi.dtos;

import com.example.livrosapi.entities.Livro;

import java.time.Year;

public record LivroResponseDTO(Long id, String titulo, String autor, String isbn, Year anoPublicacao) {
    public LivroResponseDTO(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getAnoPublicacao());
    }
}
