package br.com.citcolab.citwebservices.model.repository;

import br.com.citcolab.citwebservices.model.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
