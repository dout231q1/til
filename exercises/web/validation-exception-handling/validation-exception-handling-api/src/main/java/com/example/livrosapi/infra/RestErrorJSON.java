package com.example.livrosapi.infra;

import org.springframework.http.HttpStatus;

public class RestErrorJSON {
    private String message;
    private HttpStatus status;

    public RestErrorJSON(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() { return status; }
    public void setStatus(HttpStatus status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}