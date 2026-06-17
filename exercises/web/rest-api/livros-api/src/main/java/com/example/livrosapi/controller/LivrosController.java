package com.example.livrosapi.controller;

import com.example.livrosapi.dto.LivrosRequestDTO;
import com.example.livrosapi.dto.LivrosResponseDTO;
import com.example.livrosapi.service.LivrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private final LivrosService livrosService;

    public LivrosController(LivrosService livrosService){
        this.livrosService = livrosService;
    }

    @PostMapping
    public ResponseEntity<LivrosResponseDTO> adicionarLivros(@RequestBody LivrosRequestDTO requestDTO){
        LivrosResponseDTO novoLivro = livrosService.adicionarLivro(requestDTO);
        return ResponseEntity.ok(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivrosResponseDTO>> listarLivros(){
        List<LivrosResponseDTO> livros = livrosService.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivrosResponseDTO> buscarLivroPorId(@PathVariable Long id){
        LivrosResponseDTO livro = livrosService.buscarLivro(id);
        if (livro == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivrosResponseDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivrosRequestDTO requestDTO){
        LivrosResponseDTO livroAtualizado = livrosService.atualizarLivro(id, requestDTO);
        if(livroAtualizado == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public void removerLivroPorId(Long id){
        livrosService.deletarLivro(id);
        ResponseEntity.noContent().build();
    }


}
