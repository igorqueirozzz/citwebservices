package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.GenderEnum;
import br.com.citcolab.citwebservices.enumeration.SectorEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "citwebservices")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "employer_id", nullable = false, unique = true)
    private Long employer_id;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "Gender", length = 1, nullable = false)
    private GenderEnum gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "local_office" )
    private String local_office;

    @Column(name = "sector")
    private SectorEnum sector;

    @Column(name = "photo_profile_url")
    private String photo_profile_url;

    @Column(name = "register_update_request")
    private Enum register_update_request;
}
