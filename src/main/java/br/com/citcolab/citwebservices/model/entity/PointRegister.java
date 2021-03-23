package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.PointUpdateEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "point_register")
public class PointRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "register_date", nullable = false)
    private Date register_date;

    @Column(name = "local_register", nullable = false)
    private String local_register;

    @Column(name = "register_time", nullable = false)
    private Date register_time;

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user_id;

}
