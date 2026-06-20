package com.example.livrosapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.ISBN;

import java.time.Year;

public record LivroRequestDTO(
        @NotBlank(message = "O titulo do livro nao pode estar em branco")
        String titulo,
        @NotBlank(message = "O autor do livro nao pode estar em branco")
        String autor,
        @NotBlank(message = "O ISBN do livro nao pode estar em branco")
        @ISBN(message = "O livro deve ter um ISBN-13 valido")
        String isbn,
        @NotNull(message = "O ano de publicacao do livro nao pode ser nulo")
        @PastOrPresent(message = "O ano de publicacao do livro nao pode ser uma data futura")
        Year anoPublicacao
){
        public LivroRequestDTO{
                if(anoPublicacao != null && anoPublicacao.getValue() < 1970){
                        throw new IllegalArgumentException("O ano de publicacao nao pode ser anterior a criacao do padrao ISBN (1970)");
                }
        }
}
