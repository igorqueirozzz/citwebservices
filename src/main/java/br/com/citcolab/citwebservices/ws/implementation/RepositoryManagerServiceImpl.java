package br.com.citcolab.citwebservices.ws.implementation;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
import br.com.citcolab.citwebservices.model.entity.PointRegister;
import br.com.citcolab.citwebservices.model.repository.PointRegisterRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.ws.RepositoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
@Service
public class RepositoryManagerServiceImpl implements RepositoryManagerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PointRegisterRepository pointRegisterRepository;

    @Override
    @Transactional
    public void persistUser(UserEntity user){
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(UserEntity user){
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void persistPointRegister(PointRegister pointRegister){
        pointRegisterRepository.save(pointRegister);
    }

    @Override
    public UserDetails authUser(UserEntity user){
        UserEntity user1 = userRepository.findByCpf(user.getCpf());
        return User.builder()
                .username(user.getEmail())
                .password(user.getUserPassword())
                .build();
    }

}
