package hn.devsu.excersice.clientes.application.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hn.devsu.excersice.clientes.application.dto.ErrorResponse;
import hn.devsu.excersice.clientes.domain.exception.NotClientFoundException;
import hn.devsu.excersice.clientes.domain.exception.NotCuentaFoundException;
import hn.devsu.excersice.clientes.domain.exception.NotSaldoException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotClientFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotClientFound(NotClientFoundException nfe, HttpServletRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setFecha(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError("Cliente no encontrado");
        response.setMessage(nfe.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NotCuentaFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotCuentaException(NotCuentaFoundException nce, HttpServletRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setFecha(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError("Cuenta no encontrada");
        response.setMessage(nce.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NotSaldoException.class)
    public ResponseEntity<ErrorResponse> handleNotSaldoException(NotCuentaFoundException nse, HttpServletRequest request){
        ErrorResponse response = new ErrorResponse();
        response.setFecha(LocalDateTime.now());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setError("Cuenta sin saldo");
        response.setMessage(nse.getMessage());
        response.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
}
