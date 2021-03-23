package br.com.citcolab.citwebservices.model.repository;

import br.com.citcolab.citwebservices.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
