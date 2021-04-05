package br.com.citcolab.citwebservices.exception;

public class AuthenticationUserException extends RuntimeException {

    private static final long serialVersionUID = -7438288681796790666L;

    public AuthenticationUserException() {
        super("Email ou Senha inválidos");
    }

}
