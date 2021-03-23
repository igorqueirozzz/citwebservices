package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.PointUpdateEnum;
import br.com.citcolab.citwebservices.enumeration.PointUptadeRequestEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PointRegisterUpdate", schema = "citwebservices")
public class PointRegisterUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_register_id")
    private Long point_register_id;

    @Column(name = "justification", nullable = false)
    private String justificacion;

    @Column(name = "point_register_update", nullable = false)
    private PointUpdateEnum point_register_update;

    @Column(name = "point_register_request", nullable = false)
    private PointUptadeRequestEnum point_register_request;

}
