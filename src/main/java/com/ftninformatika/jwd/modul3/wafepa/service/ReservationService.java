package com.ftninformatika.jwd.modul3.wafepa.service;


import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;

public interface ReservationService {

	Page<Reservation> all(int pageNum);	
	Optional<Reservation> one(Long id);
	Reservation save(Reservation Reservation);
	Reservation delete(Long id);
	
	
}
