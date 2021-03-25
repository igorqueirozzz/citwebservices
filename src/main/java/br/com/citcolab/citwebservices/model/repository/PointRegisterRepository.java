package br.com.citcolab.citwebservices.model.repository;

import br.com.citcolab.citwebservices.model.entity.PointRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRegisterRepository extends JpaRepository<PointRegister, Long> {

    @Query(value = "SELECT * FROM pointregister.pointregister where user_id = ?", nativeQuery = true)
    List<PointRegister> findPointRegister(Long userId);

}
