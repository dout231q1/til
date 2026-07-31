package com.example.livrosapi.services;

import com.example.livrosapi.dtos.LivroRequestDTO;
import com.example.livrosapi.dtos.LivroResponseDTO;
import com.example.livrosapi.entities.Livro;
import com.example.livrosapi.exceptions.LivroNotFoundException;
import com.example.livrosapi.repositories.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
    @Mock
    private LivroRepository livroRepository;

    @InjectMocks
    public LivroService livroService;

    @Test
    void deveCriarUmLivroComSucesso(){
        LivroRequestDTO livro = new LivroRequestDTO("O Hobbit", "Tolkien", "12345", Year.of(2000));
        Livro livroSalvo = new Livro("O Hobbit", "Tolkien", "12345", Year.of(2000));

        when(livroRepository.save(any(Livro.class))).thenReturn(livroSalvo);

        LivroResponseDTO resultado = livroService.adicionarLivro(livro);

        assertNotNull(resultado);
        assertEquals("O Hobbit", resultado.titulo());
        assertEquals("Tolkien", resultado.autor());
    }

    @Test
    void deveListarTodosOsLivros(){
        Livro livro = new Livro("O Hobbit", "Tolkien", "12345", Year.of(2000));
        Livro livro2 = new Livro("O Hobbit1", "Tolkien1", "123451", Year.of(2001));
        List<Livro> lista = Arrays.asList(livro, livro2);

        when(livroRepository.findAll()).thenReturn(lista);

        List<LivroResponseDTO> resultado = livroService.listarLivros();

        assertNotNull(resultado);
        assertEquals("O Hobbit", livro.getTitulo());
        assertEquals("Tolkien1", livro2.getAutor());
        assertEquals(2, lista.size());
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaLivros(){
        when(livroRepository.findAll()).thenReturn(Collections.emptyList());

        List<LivroResponseDTO> resultado = livroService.listarLivros();

        assertTrue(resultado.isEmpty());
        verify(livroRepository).findAll();
    }

    @Test
    void deveBuscarLivroPorIdComSucesso(){
        Livro livro = new Livro("O Hobbit", "Tolkien", "12345", Year.of(2000));
        ReflectionTestUtils.setField(livro, "id", 1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        LivroResponseDTO resultado = livroService.buscarLivro(1L);

        assertNotNull(resultado.id());
        assertEquals("O Hobbit", resultado.titulo());
        assertEquals(1L, resultado.id());
    }

    @Test
    void deveLancarExcecaoAoBuscarLivroInexistente(){
        when(livroRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(LivroNotFoundException.class, () -> livroService.buscarLivro(99L));
    }

    @Test
    void deveAtualizarLivroComSucesso(){
        Livro livroExistente = new Livro("a", "b", "1", Year.of(2000));
        ReflectionTestUtils.setField(livroExistente, "id", 1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livroExistente));
        when(livroRepository.save(any(Livro.class))).thenReturn(livroExistente);

        LivroRequestDTO livroAtualizado = new LivroRequestDTO("O Hobbit", "Tolkien", "12345", Year.of(2000));
        LivroResponseDTO resultado = livroService.atualizarLivro(1L, livroAtualizado);

        assertNotNull(resultado);
        assertEquals("O Hobbit", resultado.titulo());
    }

    @Test
    void deveLancarExcecaoAoAtualizarLivroInexistente(){
        when(livroRepository.findById(99L)).thenReturn(Optional.empty());

        LivroRequestDTO livro = new LivroRequestDTO("O Hobbit", "Tolkien", "12345", Year.of(2000));

        assertThrows(LivroNotFoundException.class, () -> livroService.atualizarLivro(99L, livro));
    }

    @Test
    void deveDeletarLivroComSucesso() {
        Livro livro = new Livro("a", "b", "1", Year.of(2000));
        ReflectionTestUtils.setField(livro, "id", 1L);

        when(livroRepository.findById(1L)).thenReturn(Optional.of(livro));

        livroService.deletarLivro(1L);

        verify(livroRepository).delete(livro);
    }

    @Test
    void deveLancarExcecaoAoDeletarLivroInexistente(){
        when(livroRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(LivroNotFoundException.class, () -> livroService.deletarLivro(99L));
    }
}