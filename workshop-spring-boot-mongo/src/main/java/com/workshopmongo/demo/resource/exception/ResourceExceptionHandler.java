package com.workshopmongo.demo.resource.exception;

import com.workshopmongo.demo.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        var error = new StandardError(System.currentTimeMillis(), status.value(),e.getMessage(),request.getRequestURI(),"Não encontrado");
        return ResponseEntity.status(status).body(error);
    }
}
