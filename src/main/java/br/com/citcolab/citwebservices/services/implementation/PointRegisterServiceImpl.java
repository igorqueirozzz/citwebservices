package br.com.citcolab.citwebservices.services.implementation;

import br.com.citcolab.citwebservices.exception.RegisterPointException;
import br.com.citcolab.citwebservices.model.dto.RegisterPointDTO;
import br.com.citcolab.citwebservices.model.entity.PointRegister;
import br.com.citcolab.citwebservices.model.entity.UserEntity;
import br.com.citcolab.citwebservices.model.repository.PointRegisterRepository;
import br.com.citcolab.citwebservices.model.repository.UserRepository;
import br.com.citcolab.citwebservices.services.PointRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequestMapping("/api/users/register-point")
public class PointRegisterServiceImpl implements PointRegisterService {

    @Autowired
    PointRegisterRepository pointRegisterRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity registerPoint(RegisterPointDTO registerPoint, UserEntity user) {
        Date date = new Date(1617620400000L);
        RegisterPointException.checkDateTime(date);
        List<PointRegister> listRegister = pointRegisterRepository.findByRegisterDate(date);

        RegisterPointDTO teste = registerPoint;

        PointRegister pointRegister = new PointRegister();
        pointRegister.setRegister_date(registerPoint.getRegister_date());
        pointRegister.setRegister_time(registerPoint.getRegister_time());
        pointRegister.setRegister_local(registerPoint.getUser_location());
        pointRegister.setUser_id(user);
        RegisterPointException.checkRegisterTime(pointRegister, listRegister, listRegister.size());
        pointRegisterRepository.save(pointRegister);
        return ResponseEntity.accepted().build();
    }
}
