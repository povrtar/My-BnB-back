package com.ftninformatika.jwd.modul3.wafepa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
	Optional<Administrator> findFirstByUsername(String username);
	Optional<Administrator> findFirstByUsernameAndPassword(String username, String password);
}
