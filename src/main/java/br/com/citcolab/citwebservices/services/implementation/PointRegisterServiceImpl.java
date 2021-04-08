package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.RegisterPointException;
import br.com.citcolab.citwebservices.model.dto.GetRegisterMonthListDTO;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.PointRegister;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.PointRegisterRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.PointRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@RequestMapping("/api/point-controller")
public class PointRegisterServiceImpl implements PointRegisterService {

    @Autowired
    PointRegisterRepository pointRegisterRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public RegisterPointDTO registerPoint(@RequestBody RegisterPointDTO registerPoint ) {
        UserEntity userid = new UserEntity();
        userid.setId(registerPoint.getUser_id());

        RegisterPointException.checkDateTime(registerPoint.getRegister_date());
        List<PointRegister> listRegister = pointRegisterRepository.findByRegisterDate(registerPoint.getRegister_date());
        PointRegister pointRegister = new PointRegister();
        pointRegister.setRegister_date(registerPoint.getRegister_date());
        pointRegister.setRegister_time(registerPoint.getRegister_time());
        pointRegister.setRegister_local(registerPoint.getUser_location());
        pointRegister.setReference(registerPoint.getReference());
        pointRegister.setUser_id(userid);
        RegisterPointException.checkRegisterTime(pointRegister, listRegister, listRegister.size());
        pointRegisterRepository.save(pointRegister);
        return registerPoint;
    }

    @PostMapping("/get-registers-month")
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity findByReference(@RequestBody  GetRegisterMonthListDTO reference){
        List<PointRegister> registers = pointRegisterRepository.findByReference(reference.getUserId(), reference.getReference());
        RegisterPointException.notFoundRegisters(registers);
        return ResponseEntity.ok(registers);
    }

    @GetMapping("/teste")
    public  ResponseEntity teste(){
        return ResponseEntity.ok("Julho comedor de traveco");
    }


}


