package com.ftninformatika.jwd.modul3.wafepa.support;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.repository.AmenityRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;
import com.ftninformatika.jwd.modul3.wafepa.service.LocationService;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ApartmentDto;

@Component
public class ApartmentDtoToApartment implements Converter<ApartmentDto,Apartment>{
	@Autowired
	private ApartmentService apartmentService;
@Autowired
private UserService userService;
@Autowired
private LocationService locationService;
@Autowired
private AmenityRepository amenityRepository;
@Autowired
private ReservationDtoToReservation toReservation;
@Autowired
private AmenityDtoToAmenity toAmenity;
	@Override
	public Apartment convert(ApartmentDto source) {
		
		Long id = source.getId();
		Apartment apart = id == null ? new Apartment() : apartmentService.one(id).get();
		
		
		apart.setId(source.getId());
		apart.setHost(userService.one(source.getHostId()).get());
		apart.setCheckInTime(source.getCheckIn());
		apart.setCheckOutTime(source.getCheckOut());
		apart.setLocation(locationService.one(source.getLocationId()).get());
		apart.setType(source.getType());
		apart.setReservations(toReservation.convert(source.getReservationDto()));
		apart.setPricePerNight(source.getPricePerNight());
		apart.setNumberOfGuests(source.getNumberOfGuests());
		apart.setNumberOfRooms(source.getNumberOfRooms());
		apart.setStatus(source.getStatus());
		List <Amenity> amenitiesForApartment=new ArrayList<>();
		if(source.getAmenities()==null) {
			amenitiesForApartment=null;
		}else {
		amenitiesForApartment=toAmenity.convert(source.getAmenities());
		}
		
		apart.setAmenitiesForApartment(amenitiesForApartment);
		return apart;
	}

}
