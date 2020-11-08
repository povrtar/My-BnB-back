package com.ftninformatika.jwd.modul3.wafepa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.model.Gender;
import com.ftninformatika.jwd.modul3.wafepa.model.Location;
import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
import com.ftninformatika.jwd.modul3.wafepa.model.ReservationStatus;
import com.ftninformatika.jwd.modul3.wafepa.model.Role;
import com.ftninformatika.jwd.modul3.wafepa.service.AddressService;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.service.AmenityService;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;
import com.ftninformatika.jwd.modul3.wafepa.service.LocationService;
import com.ftninformatika.jwd.modul3.wafepa.service.ReservationService;


@Component
public class TestData {
@Autowired
public AmenityService amenityService;
@Autowired
private UserService userService;
@Autowired
private LocationService  locationSercvice;
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UserService adminService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
	

		for (int i = 1; i <= 3; i++) {
			User admin = new User();
			admin.setUsername("admin" + i);
			admin.setFirstName("First " + i);
			admin.setLastName("Last " + i);
			admin.setGender(Gender.MALE);
			String encodedPass = passwordEncoder.encode("pass"+i);
			admin.setPassword(encodedPass);
			admin.setRole(Role.ADMINISTRATOR);
			adminService.save(admin);
		}
		

		for (int i = 1; i <= 3; i++) {
			User guest = new User();
			guest.setUsername("guest" + i);
			guest.setFirstName("First " + i);
			guest.setLastName("Last " + i);
			guest.setGender(Gender.MALE);
			String encodedPass = passwordEncoder.encode("gpass"+i);
			guest.setPassword(encodedPass);
			guest.setRole(Role.GUEST);
			userService.save(guest);
		}

		for (int i = 1; i <= 3; i++) {
			User host = new User();
			host.setUsername("host" + i);
		host.setFirstName("First " + i);
			host.setLastName("Last " + i);
			host.setGender(Gender.MALE);
			String encodedPass = passwordEncoder.encode("pass"+i);
		host.setPassword(encodedPass);
		host.setRole(Role.HOST);
			userService.save(host);
		}
			for(int j=1; j<=2; j++) {
				Address a = new Address();	
				a.setNumber(Integer.toString(j));
				a.setStreet("Laze Nančića");	
				addressService.save(a);		
				addressService.save(a);
			}
			
		Amenity amenity1=new Amenity("Washing machine");
		Amenity amenity2=new Amenity("Parkong place");
		Amenity amenity3=new Amenity("Wifi");
		List<Amenity> amenities=new ArrayList<>();
		amenities.add(amenity3);
		amenities.add(amenity2);
		amenities.add(amenity1);
		amenityService.save(amenity1);
		amenityService.save(amenity2);
		amenityService.save(amenity3);
		Location location1=new Location(addressService.one(1L).get());
		Location location2=new Location(addressService.one(2L).get());
		locationSercvice.save(location1);
		locationSercvice.save(location2);
		Apartment apart1=new Apartment("APARTMENT",2L,4L,location1);
		apart1.setHost(userService.one(8L).get());
		apart1.setAmenitiesForApartment(amenities);
		apart1.setPricePerNight(20.00);
		Apartment apart2=new Apartment("ROOM",1L,2L,location2);
		apart2.setHost(userService.one(7L).get());
		apart2.setAmenitiesForApartment(amenities);
		apart2.setPricePerNight(30.00);
		apartmentService.save(apart1);
		apartmentService.save(apart2);
		Reservation reservation1=new Reservation(apart1,LocalDate.of(2020, 11, 18),5L,userService.one(4L).get());
		reservation1.setReservationStatus(ReservationStatus.CREATED);
		Reservation reservation2=new Reservation(apart2,LocalDate.of(2020, 11, 22),3L,userService.one(5L).get());
		reservation2.setReservationStatus(ReservationStatus.CREATED);
		System.out.println(reservation1);
		reservationService.save(reservation1);
		reservationService.save(reservation2);
		List<Reservation> reservations=new ArrayList<>();
		reservations.add(reservation1);
		apart1.setReservations(reservations);
		apartmentService.save(apart1);
		reservations.clear();
		reservations.add(reservation2);
		apart2.setReservations(reservations);
		apartmentService.save(apart2);
		
		
	}
}
