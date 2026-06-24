package com.example.livrosapi.exceptions;

public class LivroNotFoundException extends RuntimeException{
    public LivroNotFoundException(String message){
        super(message);
    }
}
