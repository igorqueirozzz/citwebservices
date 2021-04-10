package br.com.citcolab.citwebservices.exception.api;

import br.com.citcolab.citwebservices.exception.AuthenticationUserException;
import br.com.citcolab.citwebservices.exception.CPFException;
import br.com.citcolab.citwebservices.exception.RegisterPointException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(AuthenticationUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerApiAuthException(AuthenticationUserException exception){
        String errorMessage = exception.getMessage();
        return new ApiError(errorMessage);
    }

    @ExceptionHandler(CPFException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerApiCPFException(CPFException exception){
        String errorMessage = exception.getMessage();
        return new ApiError(errorMessage);
    }

    @ExceptionHandler(RegisterPointException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError handlerApiRegisterException(RegisterPointException exception){
        String errorMessage = exception.getMessage();
        return new ApiError(errorMessage);
    }

}
