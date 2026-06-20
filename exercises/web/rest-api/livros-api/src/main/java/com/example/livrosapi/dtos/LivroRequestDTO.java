package com.example.livrosapi.dtos;

import java.time.Year;

public record LivroRequestDTO(String titulo, String autor, String isbn, Year anoPublicacao){}
