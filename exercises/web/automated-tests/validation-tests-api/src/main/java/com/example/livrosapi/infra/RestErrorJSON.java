package com.example.livrosapi.infra;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"timestamp", "status", "error", "fields"})
public class RestErrorJSON {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    private String status;
    private String error;
    private Map<String, String> fields;

    public RestErrorJSON(HttpStatus status, String error) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value() + " " + status.name();
        this.error = error;
    }

    public RestErrorJSON(HttpStatus status, String error, Map<String, String> fields){
        this.timestamp = LocalDateTime.now();
        this.status = status.value() + " " + status.name();
        this.error = error;
        this.fields = fields;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public Map<String, String> getFields(){ return fields; }
    public void setFields(Map<String, String> fields) { this.fields = fields; }
}
