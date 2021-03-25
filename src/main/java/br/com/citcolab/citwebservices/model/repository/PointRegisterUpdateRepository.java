package br.com.citcolab.citwebservices.model.repository;

import br.com.citcolab.citwebservices.model.entity.PointRegisterUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRegisterUpdateRepository extends JpaRepository<PointRegisterUpdate, Long> {

}
