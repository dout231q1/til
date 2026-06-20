package com.example.livrosapi.controllers;

import com.example.livrosapi.dtos.LivroRequestDTO;
import com.example.livrosapi.dtos.LivroResponseDTO;
import com.example.livrosapi.services.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDTO> adicionarLivro(@Valid @RequestBody LivroRequestDTO requestDTO){
        LivroResponseDTO novoLivro = livroService.adicionarLivro(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarLivros(){
        List<LivroResponseDTO> livros = livroService.listarLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarLivro(@PathVariable Long id){
        LivroResponseDTO livro = livroService.buscarLivro(id);
        if(livro == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> atualizarLivro(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO requestDTO){
        LivroResponseDTO livroAtualizado = livroService.atualizarLivro(id, requestDTO);
        if(livroAtualizado == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivroPorId(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
