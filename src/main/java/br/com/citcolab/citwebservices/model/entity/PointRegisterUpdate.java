package br.com.citcolab.citwebservices.model.entity;

import br.com.citcolab.citwebservices.enumeration.PointUpdateResponse;
import br.com.citcolab.citwebservices.enumeration.PointUpdateRequestStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "point_register_update", schema = "citwebservices")
public class PointRegisterUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "point_register_id")
    private PointRegister point_register_id;

    @Column(name = "justification", nullable = false)
    private String justification;

    @Enumerated(EnumType.STRING)
    @Column(name = "register_update_response", nullable = false)
    private PointUpdateResponse register_update_response;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PointUpdateRequestStatus point_register_request;

}
