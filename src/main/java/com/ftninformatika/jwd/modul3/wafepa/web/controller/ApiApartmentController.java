package com.ftninformatika.jwd.modul3.wafepa.web.controller;

import java.time.LocalDate;
import java.util.Date;
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
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;

import com.ftninformatika.jwd.modul3.wafepa.support.ApartmentDtoToApartment;
import com.ftninformatika.jwd.modul3.wafepa.support.ApartmentToApartmentDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ApartmentDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.RecordDTO;

@RestController
@RequestMapping(value="/api/apartments")
public class ApiApartmentController {
	@Autowired
	private ApartmentService apartmentService;
	
	@Autowired
	private ApartmentToApartmentDto toDTO;
	
	@Autowired
	private ApartmentDtoToApartment toApartment;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ApartmentDto>> getApartments(
			@RequestParam(required=false) String checkIn,
			@RequestParam(required=false) String checkOut,
			@RequestParam(required=false) String city,
			@RequestParam(required=false) Double priceFrom,
			@RequestParam(required=false) Double priceTo,
			@RequestParam(required=false) Long numberOfRoomsMin,
			@RequestParam(required=false) Long numberOfRoomsMax,
			
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Apartment> apartmentsPage = null;
		
		if(checkIn != null || checkOut != null || city != null ||priceFrom!=null||priceTo!=null||
				numberOfRoomsMin!=null ||numberOfRoomsMax!=null) {
			apartmentsPage = apartmentService.search(checkIn,checkOut,city,priceFrom,priceTo,numberOfRoomsMin,numberOfRoomsMax,pageNum);
		}
		else {
			apartmentsPage = apartmentService.all(pageNum);
		}
System.out.println("APARTMENTS"+apartmentsPage.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(apartmentsPage.getTotalPages()) );
		
		return new ResponseEntity<>(
				toDTO.convert(apartmentsPage.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<ApartmentDto> getRecord(@PathVariable Long id){
		Optional<Apartment> record = apartmentService.one(id);
		if(!record.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(record.get()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<ApartmentDto> delete(@PathVariable Long id){
		Apartment deleted = apartmentService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(deleted),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<ApartmentDto> add(
			@Validated @RequestBody ApartmentDto dto){
		System.out.println("dto is "+dto.toString());
		dto.setHostId(1L);
		Apartment persisted = apartmentService.save(
				
				toApartment.convert(dto));
		System.out.println("persisted "+persisted.toString());
		return new ResponseEntity<>(
				toDTO.convert(persisted),
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<ApartmentDto> edit(
			@Validated @RequestBody ApartmentDto recordDTO,
			@PathVariable Long id){
		
		if(!id.equals(recordDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Apartment persisted = apartmentService.save(
				toApartment.convert(recordDTO));
		
		return new ResponseEntity<>(
				toDTO.convert(persisted),
				HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
