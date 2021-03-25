package br.com.citcolab.citwebservices.exception;

public class AuthenticationUserExpection extends RuntimeException {

    private static final long serialVersionUID = -7438288681796790666L;

    public AuthenticationUserExpection() {
        super("Email ou Senha inválidos");
    }

}
