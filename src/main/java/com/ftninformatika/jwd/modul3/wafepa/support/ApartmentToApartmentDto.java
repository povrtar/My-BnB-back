package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AmenityDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ApartmentDto;
@Component
public class ApartmentToApartmentDto implements Converter<Apartment,ApartmentDto> {
@Autowired
private ReservationToReservationDto resToDto;
@Autowired
private AmenityToAmenityDto toAmenityDto;
	@Override
	public ApartmentDto convert(Apartment value) {
		ApartmentDto dto=new ApartmentDto();
		dto.setId(value.getId());
		dto.setAvailability(value.getAvailability());
		dto.setHostId(value.getHost().getId());
		dto.setLocationId(value.getLocation().getId());
		dto.setNumberOfRooms(value.getNumberOfRooms());
		dto.setPricePerNight(value.getPricePerNight());
		dto.setNumberOfGuests(value.getNumberOfGuests());
		dto.setStatus(value.getStatus());
		dto.setReservationDto(resToDto.convert(value.getReservations()));
		dto.setType(value.getType().toString());
		dto.setCheckIn(value.getCheckInTime());
		dto.setCheckOut(value.getCheckOutTime());
	List<AmenityDto> amenities=new ArrayList<>();
		if(value.getAmenitiesForApartment()==null) {
			amenities=null;
		}else {
			amenities=toAmenityDto.convert(value.getAmenitiesForApartment());
		}
		dto.setAmenities(amenities);
		return dto;
	}
	
	public List<ApartmentDto> convert(List<Apartment> content) {
		List<ApartmentDto> dtoes=new ArrayList<>();
		for(Apartment apartment:content) {
			dtoes.add(convert(apartment));
		}
		return dtoes;
	}

	
	

}
