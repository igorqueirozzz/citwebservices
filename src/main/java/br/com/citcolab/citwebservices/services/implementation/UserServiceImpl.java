package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.AuthenticationUserExpection;
import br.com.citcolab.citwebservices.exception.CPFException;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.UserService;
import br.com.citcolab.citwebservices.ws.RepositoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequestMapping("/api/user")
public class UserServiceImpl implements UserService {


    @Autowired
    RepositoryManagerService repositoryManagerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    @Override
    public UserDetails auth(UserEntity user){

        CPFException.cpfValidation(userRepository.existsByCpf(user.getCpf()), "find");

        UserDetails userDetails = repositoryManagerService.authUser(user);

        boolean authPassword = passwordEncoder.matches(user.getUserPassword(), userDetails.getPassword());
        if (authPassword) {
            return userDetails;
        } else {
            throw new AuthenticationUserExpection();
        }
    }



}
