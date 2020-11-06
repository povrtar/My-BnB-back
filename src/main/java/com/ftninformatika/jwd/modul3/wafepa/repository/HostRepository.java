package com.ftninformatika.jwd.modul3.wafepa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftninformatika.jwd.modul3.wafepa.model.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Long>{
	Optional<Host> findFirstByUsername(String username);
	Optional<Host> findFirstByUsernameAndPassword(String username, String password);
}
