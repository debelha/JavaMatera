package com.matera.ContaService.exception;

public class ContaExistenteException extends RuntimeException {
    public ContaExistenteException(String message) {
        super(message);
    }
}
