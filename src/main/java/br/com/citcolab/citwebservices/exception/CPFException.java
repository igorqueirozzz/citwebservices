package br.com.citcolab.citwebservices.exception;

import br.com.citcolab.citwebservices.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CPFException extends RuntimeException{
    private static final long serialVersionUID = 4103035993698047867L;

    @Autowired
    public static UserRepository userRepository;

    public CPFException(String message){
        super(message);
    }

    public CPFException(){}

    public static void cpfValidation(boolean cpf, String message){
        boolean existsCpf = cpf;

        if(existsCpf && message.equalsIgnoreCase("save")){
            throw new CPFException("Já existe um usuário cadastrado com esse CPF");
        }
        if(!existsCpf && message.equalsIgnoreCase("find")) {
            throw new CPFException("Usuário não encontrado");
        }
    }

}
