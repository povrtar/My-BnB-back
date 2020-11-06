package com.ftninformatika.jwd.modul3.wafepa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftninformatika.jwd.modul3.wafepa.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{
	Optional<Guest> findFirstByUsername(String username);
	Optional<Guest> findFirstByUsernameAndPassword(String username, String password);
}
