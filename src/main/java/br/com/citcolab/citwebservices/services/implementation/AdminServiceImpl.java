package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.model.entity.User;
import br.com.citcolab.citwebservices.model.repository.PointRegisterRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("/admin")
public class AdminServiceImpl implements AdminService {

}
