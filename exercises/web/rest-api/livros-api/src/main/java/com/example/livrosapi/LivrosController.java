package com.example.livrosapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    @Autowired
    private LivrosService ls;

    @PostMapping
    public Livros adicionarLivros(@RequestBody Livros livro){
        return ls.adicionarLivro(livro);
    }

    @GetMapping
    public List<Livros> listarLivros(){
        return ls.listarLivros();
    }

    @GetMapping("/{id}")
    public Livros buscarLivroPorId(@PathVariable Long id){
        return ls.buscarLivro(id);
    }

    @PatchMapping("/{id}")
    public Livros atualizarLivroPorId(@PathVariable Long id, @RequestBody Livros livro){
        return ls.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void removerLivroPorId(Long id){
        ls.excluirLivro(id);
    }


}
