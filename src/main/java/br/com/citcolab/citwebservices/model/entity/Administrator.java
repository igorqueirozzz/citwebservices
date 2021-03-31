package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.AccessLevel;
import br.com.citcolab.citwebservices.enumeration.GenderEnum;
import br.com.citcolab.citwebservices.enumeration.SectorEnum;
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Data
@Table(name = "admin", schema = "citwebservices")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employer_id" ,nullable = false, unique = true)
    private Long employerId;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, nullable = false)
    private GenderEnum gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "local_office", nullable = false)
    private String local_office;

    @Enumerated(EnumType.STRING)
    @Column(name = "sector", nullable = false)
    private SectorEnum sector;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private AccessLevel accessLevel;

    @Column(name = "photo_profile", nullable = false)
    private String photo_profile;
}
