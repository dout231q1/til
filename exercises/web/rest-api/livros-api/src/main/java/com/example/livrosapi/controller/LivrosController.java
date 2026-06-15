package com.example.livrosapi.controller;

import com.example.livrosapi.entity.Livros;
import com.example.livrosapi.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    private LivrosService livrosService;

    @PostMapping
    public Livros adicionarLivros(@RequestBody Livros livro){
        return livrosService.adicionarLivro(livro);
    }

    @GetMapping
    public List<Livros> listarLivros(){
        return livrosService.listarLivros();
    }

    @GetMapping("/{id}")
    public Livros buscarLivroPorId(@PathVariable Long id){
        return livrosService.buscarLivro(id);
    }

    @PatchMapping("/{id}")
    public Livros atualizarLivroPorId(@PathVariable Long id, @RequestBody Livros livro){
        return livrosService.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void removerLivroPorId(Long id){
        livrosService.excluirLivro(id);
    }


}
