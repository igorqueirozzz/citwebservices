package br.com.citcolab.citwebservices.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "point_register", schema = "citwebservices")
public class PointRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column( nullable = false)
    private Date register_date;


    @Column(nullable = false)
    private String local_register;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date register_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

}
