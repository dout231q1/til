package com.example.livrosapi.services;

import com.example.livrosapi.dtos.LivroRequestDTO;
import com.example.livrosapi.dtos.LivroResponseDTO;
import com.example.livrosapi.entities.Livro;
import com.example.livrosapi.exceptions.LivroNotFoundException;
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
        Livro livroSalvo = livroRepository.save(livroEntity);
        return new LivroResponseDTO(livroSalvo);
    }

    // GET ALL
    public List<LivroResponseDTO> listarLivros(){
        return livroRepository.findAll()
                .stream()
                .map(livroEntity -> new LivroResponseDTO(livroEntity))
                .collect(Collectors.toList());
    }

    // GET BY ID
    public LivroResponseDTO buscarLivro(Long id){
        Livro livroBuscado = livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException("Livro nao encontrado com id " + id));
        return new LivroResponseDTO(livroBuscado);
    }

    // PUT
    public LivroResponseDTO atualizarLivro(Long id, LivroRequestDTO requestDTO){
        Livro livroEncontrado = livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException("Livro nao encontrado com id " + id));
        livroEncontrado.setTitulo(requestDTO.titulo());
        livroEncontrado.setAutor(requestDTO.autor());
        livroEncontrado.setIsbn(requestDTO.isbn());
        livroEncontrado.setAnoPublicacao(requestDTO.anoPublicacao());
        Livro livroAtualizado = livroRepository.save(livroEncontrado);
        return new LivroResponseDTO(livroAtualizado);
    }

    // DELETE
    public void deletarLivro(Long id){
        Livro livroEncontrado = livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException("Livro nao encontrado com id " + id));
        livroRepository.delete(livroEncontrado);
    }
}
