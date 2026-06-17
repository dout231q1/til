package com.example.livrosapi.service;

import com.example.livrosapi.dto.LivrosRequestDTO;
import com.example.livrosapi.dto.LivrosResponseDTO;
import com.example.livrosapi.entity.Livros;
import com.example.livrosapi.repository.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LivrosService {

    private final LivrosRepository livrosRepository;

    public LivrosService(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }

    // POST
    public LivrosResponseDTO adicionarLivro(LivrosRequestDTO requestDTO){
        Livros livroEntity = new Livros(
                requestDTO.titulo(),
                requestDTO.autor(),
                requestDTO.isbn(),
                requestDTO.anoPublicacao()
        );
         Livros livroSaved = livrosRepository.save(livroEntity);
         return new LivrosResponseDTO(livroSaved);
    }

    // GET ALL
    public List<LivrosResponseDTO> listarLivros(){
        return livrosRepository.findAll().stream()
                .map(livroEntity -> new LivrosResponseDTO(livroEntity))
                .collect(Collectors.toList());
    }

    // GET BY ID
    public LivrosResponseDTO buscarLivro(Long id){
        Livros livroBuscado = livrosRepository.findById(id).orElse(null);
        if(livroBuscado == null){return null;}
        return new LivrosResponseDTO(livroBuscado);
    }

    // PUT
    public LivrosResponseDTO atualizarLivro(Long id, LivrosRequestDTO requestDTO){
        Livros existe = livrosRepository.findById(id).orElse(null);
        if(existe == null){return null;}
        existe.setTitulo(requestDTO.titulo());
        existe.setAutor(requestDTO.autor());
        existe.setIsbn(requestDTO.isbn());
        existe.setAnoPublicacao(requestDTO.anoPublicacao());

        Livros livroSaved = livrosRepository.save(existe);
        return new LivrosResponseDTO(livroSaved);
    }

    // DELETE
    public void deletarLivro(Long id){
        livrosRepository.deleteById(id);
    }
}


