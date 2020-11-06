package com.ftninformatika.jwd.modul3.wafepa.web.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.model.Reservation;
import com.ftninformatika.jwd.modul3.wafepa.service.ReservationService;
import com.ftninformatika.jwd.modul3.wafepa.support.ReservationDtoToReservation;
import com.ftninformatika.jwd.modul3.wafepa.support.ReservationToReservationDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ApartmentDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ReservationDto;

@RestController
@RequestMapping("/api/reservations")
public class ApiReservationController {
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ReservationToReservationDto toDto;
	@Autowired
	private ReservationDtoToReservation toEntity;
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ReservationDto>> getReservations(
		/*	@RequestParam(required=false) LocalDate checkIn,
			@RequestParam(required=false) LocalDate checkOut,
			@RequestParam(required=false) String city,
			@RequestParam(required=false) Double priceFrom,
			@RequestParam(required=false) Double priceTo,
			@RequestParam(required=false) Long numberOfRoomsMin,
			@RequestParam(required=false) Long numberOfRoomsMax,
			*/
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Reservation> apartmentsPage = null;
		/*
		if(checkIn != null || checkOut != null || city != null ||priceFrom!=null||priceTo!=null||
				numberOfRoomsMin!=null ||numberOfRoomsMax!=null) {
			apartmentsPage = apartmentService.search(checkIn,checkOut,city,priceFrom,priceTo,numberOfRoomsMin,numberOfRoomsMax,pageNum);
		}
		else {*/
			apartmentsPage = reservationService.all(pageNum);
		//}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(apartmentsPage.getTotalPages()) );
		
		return new ResponseEntity<>(
				toDto.convert(apartmentsPage.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<ReservationDto> getRecord(@PathVariable Long id){
		Optional<Reservation> reservation = reservationService.one(id);
		if(!reservation.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(reservation.get()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<ReservationDto> delete(@PathVariable Long id){
		Reservation deleted = reservationService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(deleted),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<ReservationDto> add(
			@Validated @RequestBody ReservationDto dto){
		
		Reservation persisted = reservationService.save(
				toEntity.convert(dto));
		
		return new ResponseEntity<>(
				toDto.convert(persisted), 
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<ReservationDto> edit(
			@Validated @RequestBody ReservationDto dto,
			@PathVariable Long id){
		
		if(!id.equals(dto.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Reservation persisted = reservationService.save(
				toEntity.convert(dto));
		
		return new ResponseEntity<>(
				toDto.convert(persisted),
				HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
