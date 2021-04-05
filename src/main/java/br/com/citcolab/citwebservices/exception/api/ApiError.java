package br.com.citcolab.citwebservices.exception.api;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    @Getter
    private List<String> errors;

    public ApiError(String errorMessage){
        this.errors = Arrays.asList(errorMessage);
    }
    public ApiError(List<String> errors){
        this.errors = errors;
    }
}
