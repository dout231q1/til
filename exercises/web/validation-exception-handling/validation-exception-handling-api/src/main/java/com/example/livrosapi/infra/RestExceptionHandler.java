package com.example.livrosapi.infra;

import com.example.livrosapi.exceptions.LivroNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(LivroNotFoundException.class)
    private ResponseEntity<RestErrorJSON> livroNaoEncontradoException(LivroNotFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, exception.getMessage());
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<RestErrorJSON> livroArgumentoInvalidoException(MethodArgumentNotValidException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> errors = new HashMap<>();

        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        RestErrorJSON respostaJSON = new RestErrorJSON(status, "Erro de validacao nos campos preenchidos.", errors);

        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<RestErrorJSON> requisicaoJSONInvalidoException(HttpMessageNotReadableException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "O corpo da requisicao JSON esta malformado ou possui erros de sintaxe.");
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<RestErrorJSON> parametroURLInvalidoException(MethodArgumentTypeMismatchException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "O parametro enviado na URL possui um tipo de dado invalido.");
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<RestErrorJSON> metodoHttpNaoSuportadoException(HttpRequestMethodNotSupportedException exception){
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "O metodo HTTP utilizado nao e suportado para este endpoint.");
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<RestErrorJSON> livroDadosDuplicadosException(DataIntegrityViolationException exception){
        HttpStatus status = HttpStatus.CONFLICT;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "Ja existe um livro cadastrado com estes mesmos dados (ISBN duplicado).");
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    private ResponseEntity<RestErrorJSON> midiaNaoSuportadaException(HttpMediaTypeNotSupportedException exception){
        HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "O formato de midia enviado nao e suportado. Apenas formatos em JSON sao aceitos");
        return ResponseEntity.status(status).body(respostaJSON);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<RestErrorJSON> erroInternoServidorException(Exception exception){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        RestErrorJSON respostaJSON = new RestErrorJSON(status, "Ocorreu um erro interno inesperado no servidor. Tente novamente mais tarde.");
        return ResponseEntity.status(status).body(respostaJSON);
    }
}