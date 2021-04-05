package br.com.citcolab.citwebservices.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "point_register", schema = "citwebservices")
public class PointRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "register_date", nullable = false)
    private Date register_date;


    @Column(name = "register_local", nullable = false)
    private String register_local;

    @Temporal(TemporalType.TIME)
    @Column(name = "register_time", nullable = false)
    private Date register_time;

    @Column(name = "reference", nullable = false)
    private String reference;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user_id;

}
