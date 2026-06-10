package com.example.livrosapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    // POST
    public Livros adicionarLivro(Livros livro){
        return livrosRepository.save(livro);
    }

    // GET ALL
    public List<Livros> listarLivros(){
        return livrosRepository.findAll();
    }

    // GET BY ID
    public Livros buscarLivro(Long id){
        return livrosRepository.findById(id).orElse(null);
    }

    // PATCH
    public Livros atualizarLivro(Long id, Livros livro){
        Livros existe = livrosRepository.findById(id).orElse(null);
        if (existe == null){return null;}
        existe.setTitulo(livro.getTitulo());
        return livrosRepository.save(existe);
    }

    // DELETE
    public void excluirLivro(Long id){
        livrosRepository.deleteById(id);
    }
}
