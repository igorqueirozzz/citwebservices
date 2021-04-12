package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.AccessLevel;
import br.com.citcolab.citwebservices.enumeration.GenderEnum;
import br.com.citcolab.citwebservices.enumeration.SectorEnum;
import br.com.citcolab.citwebservices.helper.UserSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "citwebservices")
@JsonSerialize(using = UserSerializer.class)
@JsonDeserialize
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employer_id", nullable = false, unique = true)
    private Long employerId;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "user_name" ,nullable = false)
    private String user_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",nullable = false)
    private GenderEnum gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password",nullable = false)
    private String user_password;

    @Column(name = "occupation", nullable = false)
    private String occupation;

    @Column(name = "local_office", nullable = false)
    private String local_office;

    @Enumerated(EnumType.STRING)
    @Column(name = "sector")
    private SectorEnum sector;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private AccessLevel access_level;

    @Column(name = "photo_profile")
    private String photo_profile_url;

}
