package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ReservationDto;

@Component
public class ReservationToReservationDto implements Converter<Reservation,ReservationDto>{

	@Override
	public ReservationDto convert(Reservation source) {
		ReservationDto dto=new ReservationDto();
		dto.setId(source.getId());
		dto.setApartmentId(source.getApartment().getId());
		dto.setCheckIn(source.getCheckInDate());
		dto.setGuestId(source.getGuest().getId());
		dto.setNights(source.getNights());
		dto.setResStatus(source.getReservationStatus().toString());
		dto.setTotalPrice(source.getTotalPrice());
		return dto;
	}

	public List<ReservationDto> convert(List<Reservation> content) {
		List<ReservationDto> dtos=new ArrayList<>();
		if(content==null) {
			return null;
		}
		for(Reservation res:content) {
			dtos.add(convert(res));
		}
		return dtos;
	}

}
