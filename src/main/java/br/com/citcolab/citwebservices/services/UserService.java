package br.com.citcolab.citwebservices.services;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails auth(UserEntity user);
}
