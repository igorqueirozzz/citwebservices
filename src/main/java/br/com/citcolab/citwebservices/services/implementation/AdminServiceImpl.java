package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.AuthenticationUserException;
import br.com.citcolab.citwebservices.exception.CPFException;
import br.com.citcolab.citwebservices.model.dto.CredentialsDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.Administrator;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.AdministratorRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.AdminService;
import br.com.citcolab.citwebservices.services.PointRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdministratorRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PointRegisterService pointRegisterService;

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity createUser(@RequestBody UserEntity userEntity) {

        boolean cpfAlreadyInUse = userRepository.existsByCpf(userEntity.getCpf());

        CPFException.cpfValidation(cpfAlreadyInUse, "save");

        userEntity.setUser_password(passwordEncoder.encode(userEntity.getUser_password()));
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);

    }

    @PostMapping("/createAdmin")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity createAdmin(@RequestBody Administrator admin) {
        boolean cpfAlreadyInUse = adminRepository.existsByCpf(admin.getCpf());

        CPFException.cpfValidation(cpfAlreadyInUse, "save");

        admin.setUser_password(passwordEncoder.encode(admin.getUser_password()));
        adminRepository.save(admin);
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Override
    public Administrator auth(@RequestBody CredentialsDTO credentialsDTO) {
        Administrator admin = adminRepository.findByEmail(credentialsDTO.getEmail_login());
        if (admin == null){
            throw new AuthenticationUserException();
        }
        boolean passwordMatcher = passwordEncoder.matches(credentialsDTO.getPassword(), admin.getUser_password());
        if(passwordMatcher){
            return admin;
        }else {
            throw new AuthenticationUserException();
        }
    }

    @PostMapping("/register-point")
    @Override
    public void registerPoint(@RequestBody RegisterPointDTO registerPoint) {
        pointRegisterService.registerPoint(registerPoint);
    }
}
