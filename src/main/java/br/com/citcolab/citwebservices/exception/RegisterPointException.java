package br.com.citcolab.citwebservices.exception;

import br.com.citcolab.citwebservices.model.entity.PointRegister;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterPointException extends RuntimeException {

    private static final long serialVersionUID = 3054527412432131539L;

    public RegisterPointException(String message){
        super(message);
    }

    public RegisterPointException(){}

    public static void checkDateTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(calendar.get(Calendar.DAY_OF_WEEK) == calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            throw new RegisterPointException("Registro não autorizado fora da jornada de trabalho");
        }
    }

    public static void checkRegisterTime(PointRegister pointRegister, List<PointRegister> pointRegisterList, Integer amount){

        if (pointRegister == null){
            throw new RegisterPointException("Registro de ponto não encontrado");
        }

        if (amount == 4){
            throw new RegisterPointException("Quantidade de registros diários atinginda");
        }

    }

}
