package br.com.citcolab.citwebservices.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetRegisterMonthListDTO {

    private Long userId;
    private String reference;

}
