package com.ftninformatika.jwd.modul3.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
