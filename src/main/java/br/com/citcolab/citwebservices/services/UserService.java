package br.com.citcolab.citwebservices.services;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {
    UserEntity auth(CredentialsDTO credentialsDTO);
    ResponseEntity updatePhoto(Long userid, String photoUrl);
    ResponseEntity registerPoint(RegisterPointDTO registerPoint);

}
