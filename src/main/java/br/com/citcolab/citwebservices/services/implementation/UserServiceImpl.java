package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.AuthenticationUserException;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.PointRegisterService;
import br.com.citcolab.citwebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PointRegisterService pointRegisterService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public UserEntity auth(@RequestBody CredentialsDTO userCredentials){

        UserEntity user = userRepository.findByEmail(userCredentials.getEmail_login());
        if (user == null){
            throw new AuthenticationUserException();
        }
        boolean matchPassword = passwordEncoder.matches(userCredentials.getPassword(), user.getUser_password());
           if (matchPassword){
               return user;
           }else {
               throw new AuthenticationUserException();
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

    @PostMapping("/register-point")
    @Override
    public ResponseEntity registerPoint(@RequestBody RegisterPointDTO registerPoint) {
        pointRegisterService.registerPoint(registerPoint, userRepository.findById(registerPoint.getUser_id()));
        return ResponseEntity.ok().build();
    }
}
