package com.example.livrosapi.infra;

import com.example.livrosapi.exceptions.LivroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(LivroNotFoundException.class)
    private ResponseEntity<RestErrorJSON> livroNaoEncontradoException(LivroNotFoundException exception){
        RestErrorJSON respostaJSON = new RestErrorJSON(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaJSON);
    }
}