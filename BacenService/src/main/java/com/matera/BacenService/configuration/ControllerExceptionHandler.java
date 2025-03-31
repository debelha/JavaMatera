package com.matera.BacenService.configuration;

import com.matera.BacenService.exception.ChaveCadastradaException;
import com.matera.BacenService.exception.ChaveNaoLocalizadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ChaveCadastradaException.class)
    private ProblemDetail handlerChaveCadastradaException(ChaveCadastradaException chaveException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, chaveException.getMessage());
        problemDetail.setTitle("Chave duplicada");
        problemDetail.setType(URI.create("http://localhost/8080/document/chave-duplicada"));
        return problemDetail;
    }

    @ExceptionHandler(ChaveNaoLocalizadaException.class)
    private ProblemDetail handlerChaveNaoLocalizadaException(ChaveNaoLocalizadaException chaveException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, chaveException.getMessage());
        problemDetail.setTitle("Chave não existe");
        problemDetail.setType(URI.create("http://localhost/8080/document/chave-inexistente"));
        return problemDetail;
    }
}
