package br.com.citcolab.citwebservices.model.repository;

import br.com.citcolab.citwebservices.model.entity.PointRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRegisterRepository extends JpaRepository<PointRegister, Long> {
}
