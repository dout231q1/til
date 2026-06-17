package com.example.livrosapi.dto;

import java.time.Year;

public record LivrosRequestDTO(String titulo, String autor, String isbn, Year anoPublicacao){}
