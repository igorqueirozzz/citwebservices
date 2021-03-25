package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.PointUpdateResponse;
import br.com.citcolab.citwebservices.enumeration.PointUpdateRequestStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PointRegisterUpdate", schema = "citwebservices")
public class PointRegisterUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "point_register_id")
    private Long point_register_id;

    @Column(nullable = false)
    private String justification;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false)
    private PointUpdateResponse point_register_update;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PointUpdateRequestStatus point_register_request;

}
