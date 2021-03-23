package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.model.entity.User;
import br.com.citcolab.citwebservices.model.repository.PointRegisterRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PointRegisterRepository pointRegisterRepository;

   /*
   *
   * PARA USUÁRIOS COM NIVEL DE ACESSO ADMIN
   *
    */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteUser/{cpf}")
    public ResponseEntity deleteUser(String cpf){
        User user = userRepository.findByCpf(cpf).get();
        userRepository.delete(user);
        return ResponseEntity.ok(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User newUser){
        return userRepository.findById(id)
                .map(userFounded -> {
                    newUser.setId(userFounded.getId());
                    userRepository.save(newUser);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**************************************************************************************/

    @ResponseBody
    @GetMapping("/getUser/{email}")
    public User getUser(@PathVariable String email){
        return userRepository.findByEmail(email).get();
    }

}
