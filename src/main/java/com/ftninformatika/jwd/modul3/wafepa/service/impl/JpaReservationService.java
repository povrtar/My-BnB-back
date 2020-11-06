package com.ftninformatika.jwd.modul3.wafepa.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.model.Guest;
import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
import com.ftninformatika.jwd.modul3.wafepa.repository.ReservationRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;
import com.ftninformatika.jwd.modul3.wafepa.service.GuestService;
import com.ftninformatika.jwd.modul3.wafepa.service.ReservationService;
@Service
public class JpaReservationService implements ReservationService {
@Autowired
private ReservationRepository reservationRepository;
@Autowired
private ApartmentService apartmentService;
@Autowired
private GuestService guestService;

@Override
public Page<Reservation> all(int pageNum) {
	return reservationRepository.findAll(PageRequest.of(pageNum, 5));
}

@Override
public Optional<Reservation> one(Long id) {
	return reservationRepository.findById(id);
}

@Override
public Reservation save(Reservation reservation) {
	
	Apartment apartment=reservation.getApartment();
	reservation.setTotalPrice(apartment.getPricePerNight()*reservation.getNights());
	
	Reservation persisted= reservationRepository.save(reservation);
	List<Reservation> reservations=apartment.getReservations();
	reservations.add(persisted);
	apartment.setReservations(reservations);
	apartmentService.save(apartment);
	Guest guest=persisted.getGuest();
	reservations.clear();
	reservations=guest.getReservations();
	reservations.add(persisted);
	guest.setReservations(reservations);
	guestService.save(guest);
	return persisted;
}

@Override
public Reservation delete(Long id) {
Optional<Reservation> reservation=reservationRepository.findById(id);
if (reservation.isPresent()) {
	reservationRepository.deleteById(id);
	return reservation.get();
}
	return null;
}
	

}
