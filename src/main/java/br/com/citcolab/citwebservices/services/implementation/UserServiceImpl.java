package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.AuthenticationUserExpection;
import br.com.citcolab.citwebservices.exception.CPFException;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.UserService;
import br.com.citcolab.citwebservices.ws.RepositoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserServiceImpl implements UserService {


    @Autowired
    RepositoryManagerService repositoryManagerService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public UserEntity auth(@RequestBody CredentialsDTO userCredentials){

        UserEntity user = userRepository.findByEmail(userCredentials.getEmail_login());
        boolean matchPassword = passwordEncoder.matches(userCredentials.getPassword(), user.getUserPassword());
           if (matchPassword){
               return user;
           }else {
               throw new AuthenticationUserExpection();
           }
    }

    @PostMapping("/update")
    @Override
    public ResponseEntity updatePhoto(@RequestParam Long userid,@RequestParam String photoUrl) {
        userRepository.findById(userid).map(user ->{
            user.setPhoto_profile_url(photoUrl);
            userRepository.save(user);
            return user;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return ResponseEntity.ok().build();
    }

}
