package com.ftninformatika.jwd.modul3.wafepa.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.wafepa.model.Location;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;

import com.ftninformatika.jwd.modul3.wafepa.web.dto.ActivityDto;

@RestController
@RequestMapping("api/activities")
public class ApiActivityController {

	/*@Autowired
	private ApartmentService activityService;
	
	
	
	@GetMapping
	public ResponseEntity<List<ActivityDto>> getAll(
			@RequestParam(required = false) String name){
		
		List<Location> activities;
		if(name != null) {
			activities = activityService.byName(name);
		}else {
			activities = activityService.all();
		}
		
		List<ActivityDto> body = toDto.convert(activities);
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ActivityDto> getOne(@PathVariable Long id){
		Optional<Location> activity = activityService.one(id);
		
		if(activity.isPresent()) {
			ActivityDto body = toDto.convert(activity.get());
			return new ResponseEntity<>(body, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	@Secured({"ROLE_ADMIN", "ROLE_TRAINER"})
	public ResponseEntity<ActivityDto> delete(@PathVariable Long id){
		Location deleted = activityService.delete(id);
		
		if(deleted != null) {
			return new ResponseEntity<>(toDto.convert(deleted), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ActivityDto> add(@RequestBody ActivityDto toAdd){
		Location converted = toActivity.convert(toAdd);
		Location persisted = activityService.save(converted);
		
		ActivityDto body = toDto.convert(persisted);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ActivityDto> update(
			@PathVariable Long id,
			@RequestBody ActivityDto toEdit){
		
		if(!id.equals(toEdit.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Location converted = toActivity.convert(toEdit);
		Location edited = activityService.save(converted);
		ActivityDto body = toDto.convert(edited);
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	*/
}
