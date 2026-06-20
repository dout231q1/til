package com.example.livrosapi.services;

import com.example.livrosapi.dtos.LivroRequestDTO;
import com.example.livrosapi.dtos.LivroResponseDTO;
import com.example.livrosapi.entities.Livro;
import com.example.livrosapi.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    // POST
    public LivroResponseDTO adicionarLivro(LivroRequestDTO requestDTO){
        Livro livroEntity = new Livro(
                requestDTO.titulo(),
                requestDTO.autor(),
                requestDTO.isbn(),
                requestDTO.anoPublicacao()
        );
        Livro livroSaved = livroRepository.save(livroEntity);
        return new LivroResponseDTO(livroSaved);
    }

    // GET ALL
    public List<LivroResponseDTO> listarLivro(){
        return livroRepository.findAll().stream()
                .map(livroEntity -> new LivroResponseDTO(livroEntity))
                .collect(Collectors.toList());
    }

    // GET BY ID
    public LivroResponseDTO buscarLivro(Long id){
        Livro livroBuscado = livroRepository.findById(id).orElse(null);
        if(livroBuscado == null){return null;}
        return new LivroResponseDTO(livroBuscado);
    }

    // PUT
    public LivroResponseDTO atualizarLivro(Long id, LivroRequestDTO requestDTO){
        Livro existe = livroRepository.findById(id).orElse(null);
        if(existe == null){return null;}
        existe.setTitulo(requestDTO.titulo());
        existe.setAutor(requestDTO.autor());
        existe.setIsbn(requestDTO.isbn());
        existe.setAnoPublicacao(requestDTO.anoPublicacao());

        Livro livroSaved = livroRepository.save(existe);
        return new LivroResponseDTO(livroSaved);
    }

    // DELETE
    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
}