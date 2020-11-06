package com.ftninformatika.jwd.modul3.wafepa.web.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.service.AmenityService;
import com.ftninformatika.jwd.modul3.wafepa.support.AmenityDtoToAmenity;
import com.ftninformatika.jwd.modul3.wafepa.support.AmenityToAmenityDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AmenityDto;


@RestController
@RequestMapping("/api/amenities")
public class ApiAmenityController {
	@Autowired
	private AmenityService amenityService;
	@Autowired
	private AmenityToAmenityDto toDto;
	@Autowired
	private AmenityDtoToAmenity toEntity;
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<AmenityDto>> getAmenities(){
		List<Amenity> amenities=amenityService.all();	
		return new ResponseEntity<>(
				toDto.convert(amenities),
							HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<AmenityDto> getAmenity(@PathVariable Long id){
		Optional<Amenity> amenity = amenityService.one(id);
		if(!amenity.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(amenity.get()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<AmenityDto> delete(@PathVariable Long id){
		Amenity deleted = amenityService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(deleted),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<AmenityDto> add(
			@Validated @RequestBody AmenityDto dto){
		
		Amenity persisted = amenityService.save(
				toEntity.convert(dto));
		
		return new ResponseEntity<>(
				toDto.convert(persisted), 
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<AmenityDto> edit(
			@Validated @RequestBody AmenityDto dto,
			@PathVariable Long id){
		
		if(!id.equals(dto.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Amenity persisted = amenityService.save(
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
