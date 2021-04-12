package br.com.citcolab.citwebservices.services;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {
    ResponseEntity auth(CredentialsDTO credentialsDTO) throws JsonProcessingException;
    ResponseEntity updatePhoto(Long userid, String photoUrl);
    void registerPoint(RegisterPointDTO registerPoint);

}
