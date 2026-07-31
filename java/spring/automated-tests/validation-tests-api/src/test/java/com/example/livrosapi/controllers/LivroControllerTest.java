package com.example.livrosapi.controllers;

import com.example.livrosapi.dtos.LivroRequestDTO;
import com.example.livrosapi.dtos.LivroResponseDTO;
import com.example.livrosapi.exceptions.LivroNotFoundException;
import com.example.livrosapi.services.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.Year;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LivroController.class)
class LivroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LivroService livroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void post_deveRetornar201QuandoLivroExiste() throws Exception {
        LivroRequestDTO novoLivro = new LivroRequestDTO("O Hobbit", "Tolkien", "9788533613379", Year.of(2000));
        LivroResponseDTO livroCriado = new LivroResponseDTO(1L, "O Hobbit", "Tolkien", "9788533613379", Year.of(2000));

        when(livroService.adicionarLivro(any(LivroRequestDTO.class))).thenReturn(livroCriado);

        mockMvc.perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(novoLivro)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @ParameterizedTest
    @MethodSource("livrosComCampoObrigatorioFaltando")
    void post_deveRetornar400QuandoCamposObrigatoriosFaltando(LivroRequestDTO livroInvalido) throws Exception {
        mockMvc.perform(post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroInvalido)))
                .andExpect(status().isBadRequest());
    }

    static Stream<LivroRequestDTO> livrosComCampoObrigatorioFaltando() {
        return Stream.of(new LivroRequestDTO(null, "Tolkien", "9788533613379", Year.of(2000)),
                new LivroRequestDTO("", "Tolkien", "9788533613379", Year.of(2000)),
                new LivroRequestDTO("   ", "Tolkien", "9788533613379", Year.of(2000))
        );
    }

    @Test
    void post_deveRetornar400QuandoIsbnInvalido() throws Exception {
        LivroRequestDTO livroComIsbnInvalido = new LivroRequestDTO("O Hobbit", "Tolkien", "12345", Year.of(2000));

        mockMvc.perform(post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroComIsbnInvalido)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void post_deveRetornar400QuandoAnoForFuturo() throws Exception {
        LivroRequestDTO livroComAnoFuturo = new LivroRequestDTO("O Hobbit", "Tolkien", "12345", Year.of(3026));

        mockMvc.perform(post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroComAnoFuturo)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void post_deveRetornar400QuandoAnoForAnteriorA1970() throws Exception {
        String jsonComAnoInvalido = """
        {
            "titulo": "O Hobbit",
            "autor": "Tolkien",
            "isbn": "9788533613379",
            "anoPublicacao": 1950
        }
        """;

        mockMvc.perform(post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(jsonComAnoInvalido)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void post_deveRetornar409QuandoIsbnJaExiste() throws Exception {
        LivroRequestDTO livroDuplicado = new LivroRequestDTO("O Hobbit", "Tolkien", "9788533613379", Year.of(2000));

        when(livroService.adicionarLivro(any(LivroRequestDTO.class))).thenThrow(new DataIntegrityViolationException("ISBN ja cadastrado"));

        mockMvc.perform(post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroDuplicado)))
                .andExpect(status().isConflict());
    }

    @Test
    void getById_deveRetornar200QuandoLivroExiste() throws Exception {
        LivroResponseDTO livroExistente = new LivroResponseDTO(1L, "O Hobbit", "Tolkien", "12345", Year.of(2000));
        when(livroService.buscarLivro(1L)).thenReturn(livroExistente);

        mockMvc.perform(get("/livros/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.titulo").value("O Hobbit"))
                .andExpect(jsonPath("$.autor").value("Tolkien"))
                .andExpect(jsonPath("$.isbn").value("12345"))
                .andExpect(jsonPath("$.anoPublicacao").value(2000));
    }

    @Test
    void getById_deveRetornar404QuandoLivroNaoExiste() throws Exception {
        when(livroService.buscarLivro(99L)).thenThrow(new LivroNotFoundException("Nao foi possivel encontrar um livro com este id"));

        mockMvc.perform(get("/livros/99")).andExpect(status().isNotFound());
    }

    @Test
    void put_deveRetornar200QuandoLivroForAtualizado() throws Exception {
        LivroRequestDTO livroParaAtualizar = new LivroRequestDTO("a", "b", "9788533613379", Year.of(2000));
        LivroResponseDTO livroAtualizado = new LivroResponseDTO(1L, "O Hobbit", "Tolkien", "9788533613379", Year.of(2000));
        when(livroService.atualizarLivro(eq(1L), any(LivroRequestDTO.class))).thenReturn(livroAtualizado);

        mockMvc.perform(put("/livros/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroParaAtualizar)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.titulo").value("O Hobbit"));
    }

    @Test
    void put_deveRetornar404QuandoAtualizaLivroInexistente() throws Exception {
        LivroRequestDTO livroParaAtualizarInexistente = new LivroRequestDTO("a", "b", "9788533613379", Year.of(2000));

        when(livroService.atualizarLivro(eq(99L), any(LivroRequestDTO.class))).thenThrow(new LivroNotFoundException("Nao foi possivel encontrar um livro com este id"));

        mockMvc.perform(put("/livros/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(livroParaAtualizarInexistente)))
                .andExpect(status().isNotFound());
    }

    @Test
    void delete_deveRetornar204QuandoLivroForDeletadoComSucesso() throws Exception {
        doNothing().when(livroService).deletarLivro(1L);

        mockMvc.perform(delete("/livros/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void delete_deveRetornar404QuandoDeletaLivroInexistente() throws Exception {
        doThrow(new LivroNotFoundException("Nao foi possivel encontrar um livro com este id"))
                .when(livroService).deletarLivro(99L);

        mockMvc.perform(delete("/livros/99"))
                .andExpect(status().isNotFound());
    }
}