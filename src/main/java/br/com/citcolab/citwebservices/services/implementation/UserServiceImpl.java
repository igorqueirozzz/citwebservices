package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.AuthenticationUserException;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.dto.UpdatePhotoDTO;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.PointRegisterService;
import br.com.citcolab.citwebservices.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

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
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity auth(@RequestBody CredentialsDTO userCredentials) throws JsonProcessingException {

        UserEntity user = userRepository.findByEmail(userCredentials.getEmail_login());
        List<UserEntity> userArray = new ArrayList<>();
        userArray.add(user);
        if (user == null){
            throw new AuthenticationUserException();
        }
        boolean matchPassword = passwordEncoder.matches(userCredentials.getPassword(), user.getUser_password());
           if (matchPassword){
               String serialized = new ObjectMapper().writeValueAsString(userArray);
               return ResponseEntity.ok(serialized);
           }else {
               throw new AuthenticationUserException();
           }
    }

    @PostMapping("/update-photo")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity updatePhoto(@RequestBody UpdatePhotoDTO updatePhotoDTO) {
        userRepository.findById(updatePhotoDTO.getUserid()).map(user ->{
            user.setPhoto_profile_url(updatePhotoDTO.getPhotoUrl());
            userRepository.save(user);
            return user;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return ResponseEntity.ok("Foto atualizada com sucesso");
    }

    @PostMapping("/register-point")
    @Override
    public void registerPoint(@RequestBody RegisterPointDTO registerPoint) {
        pointRegisterService.registerPoint(registerPoint);
    }
}
