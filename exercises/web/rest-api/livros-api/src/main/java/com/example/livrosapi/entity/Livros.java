package com.example.livrosapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Year;

@Entity
public class Livros{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Year anoPublicacao;

    public Livros(){}

    public Livros(String titulo, String autor, String isbn, Year anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {return id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public Year getAnoPublicacao() {return anoPublicacao;}
    public void setAnoPublicacao(Year anoPublicacao) {this.anoPublicacao = anoPublicacao;}
}