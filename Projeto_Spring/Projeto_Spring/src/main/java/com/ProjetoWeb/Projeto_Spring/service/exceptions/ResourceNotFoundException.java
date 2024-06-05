package com.ProjetoWeb.Projeto_Spring.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found id " + id);
    }
}
