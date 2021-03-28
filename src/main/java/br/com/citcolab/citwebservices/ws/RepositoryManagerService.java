package br.com.citcolab.citwebservices.ws;

import br.com.citcolab.citwebservices.model.entity.PointRegister;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface RepositoryManagerService {

    void persistUser(UserEntity user);
    void deleteUser(UserEntity user);
    UserDetails authUser(UserEntity user);
    void persistPointRegister(PointRegister pointRegister);
}
