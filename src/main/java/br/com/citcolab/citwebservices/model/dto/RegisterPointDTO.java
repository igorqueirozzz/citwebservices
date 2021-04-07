package br.com.citcolab.citwebservices.model.dto;

import br.com.citcolab.citwebservices.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterPointDTO implements Serializable {

    private static final long serialVersionUID = -2340861764386969945L;

    private Long user_id;
    private String user_location;
    private Date register_date;
    private Date register_time;
    private String reference;
    UserEntity userEntity;
}
