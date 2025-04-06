package com.matera.ContaService.configuration;

import com.matera.ContaService.exception.ContaExistenteException;
import com.matera.ContaService.exception.ContaInexistenteException;
import com.matera.ContaService.exception.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContaExistenteException.class)
    private ProblemDetail exceptionContaExistente(ContaExistenteException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());
        problemDetail.setTitle("Conta existente");
        problemDetail.setType(URI.create("http://localhost/8080/doc/conta-existente"));
        return problemDetail;
    }

    @ExceptionHandler(ContaInexistenteException.class)
    private ProblemDetail exceptionContaInexistente(ContaInexistenteException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Conta ineexistente");
        problemDetail.setType(URI.create("http://localhost/8080/doc/conta-inexistente"));
        return problemDetail;
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    private ProblemDetail handleSaldoInsuficiente(SaldoInsuficienteException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        problemDetail.setTitle("Saldo insuficiente");
        problemDetail.setType(URI.create("https://localhost/8080/doc/saldo-insuficiente"));
        return problemDetail;
    }
}
