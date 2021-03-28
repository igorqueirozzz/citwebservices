package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.CPFException;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
@Component
@RequestMapping("/api/admin")
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity createUser(@RequestBody UserEntity userEntity) {

        boolean cpfAlreadyInUse = userRepository.existsByCpf(userEntity.getCpf());

        CPFException.cpfValidation(cpfAlreadyInUse, "save");

        userEntity.setUserPassword(passwordEncoder.encode(userEntity.getUserPassword()));
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);

    }
}
