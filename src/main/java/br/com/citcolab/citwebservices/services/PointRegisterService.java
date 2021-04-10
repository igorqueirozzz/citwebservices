package br.com.citcolab.citwebservices.services;

import br.com.citcolab.citwebservices.model.dto.GetRegisterMonthListDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.PointRegister;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public interface PointRegisterService {

    ResponseEntity registerPoint(RegisterPointDTO registerPoint );
   ResponseEntity findByReference(GetRegisterMonthListDTO reference) throws JsonProcessingException;
}
