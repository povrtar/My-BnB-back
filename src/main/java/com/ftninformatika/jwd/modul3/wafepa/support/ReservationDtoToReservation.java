package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
import com.ftninformatika.jwd.modul3.wafepa.model.ReservationStatus;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;
import com.ftninformatika.jwd.modul3.wafepa.service.ReservationService;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ReservationDto;

@Component
public class ReservationDtoToReservation implements Converter<ReservationDto,Reservation>{
@Autowired
private ReservationService reservationService;
@Autowired
private ApartmentService apartmentService;
@Autowired
private UserService guestService;

	@Override
	public Reservation convert(ReservationDto source) {
		Reservation reservation=null;
		if(source.getId()!=null) {
		reservation=	reservationService.one(source.getId()).get();	
		}
		if(reservation==null) {
			reservation=new Reservation();
		}
		reservation.setApartment(apartmentService.one(source.getApartmentId()).get());
		reservation.setCheckInDate(source.getCheckIn());
		reservation.setGuest(guestService.one(source.getGuestId()).get());
		reservation.setNights(source.getNights());
		reservation.setTotalPrice(source.getTotalPrice());
		ReservationStatus status=null;
		switch(source.getResStatus().toLowerCase()) {
		case "created":
			 status =ReservationStatus.CREATED;
			break;
		case "rejected":
			 status =ReservationStatus.REJECTED;
			break;
		case "canceled":
			 status =ReservationStatus.CANCELED;
			break;
		case "completed":
			 status =ReservationStatus.FINISHED;
			break;
			
			
		}
		reservation.setReservationStatus(status);
		return reservation;
	}
public List<Reservation> convert(List<ReservationDto> source){
	List<Reservation> res=new ArrayList<>();
	if (source==null) {
		return null;
	}
	for(ReservationDto dto:source) {
		res.add(convert(dto));
	}
	return res;
}
}
