package com.company.oms.exception;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class ServerError {
    private Instant timestamp = Instant.now();
    private HttpStatus status;
    private String message;

    public ServerError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
