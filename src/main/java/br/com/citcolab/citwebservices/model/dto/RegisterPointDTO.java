package br.com.citcolab.citwebservices.model.dto;

import br.com.citcolab.citwebservices.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterPointDTO {
    private Integer user_id;
    private String user_location;
    private Date register_date;
    private Date register_time;
}
