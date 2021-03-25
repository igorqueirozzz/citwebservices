package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.AccessLevel;
import br.com.citcolab.citwebservices.enumeration.GenderEnum;
import br.com.citcolab.citwebservices.enumeration.SectorEnum;
import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Data
@Table(name = "users", schema = "citwebservices")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, unique = true)
    private Long employer_id;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private GenderEnum gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    @Column
    private String occupation;

    @Column
    private String local_office;

    @Enumerated(EnumType.STRING)
    @Column(name = "sector")
    private SectorEnum sector;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessLevel accessLevel;

    @Column
    private Blob photo_profile_url;

}
