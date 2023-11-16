package com.drc.gestao.exception;

public class UserFoundException extends RuntimeException{
    // mensagem de exeception p usuário
    public UserFoundException(){
        super("Usuário já existe");
    }
}
