package com.ProjetoWeb.Projeto_Spring.service.exceptions;

public class DatabaseExecption extends RuntimeException{
    public DatabaseExecption(String msg){
        super(msg);
    }
}
