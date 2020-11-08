package com.ftninformatika.jwd.modul3.wafepa.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.service.AddressService;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.support.AddressDtoToAddress;
import com.ftninformatika.jwd.modul3.wafepa.support.AddressToAddressDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AddressDto;

@RestController
@RequestMapping("api/users/{userId}/addresses")
public class ApiAddressController{
	/*
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressToAddressDto toDto;
	
	@Autowired
	private AddressDtoToAddress toAddress;
	
	@Autowired
	private AdministratorService userService;

	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> get(@PathVariable Long id, @PathVariable Long userId){
		Optional<Address> address = addressService.one(id);
		
		if(address.isPresent()) {
			if(address.get().getUser() == null ||
					!userId.equals(address.get().getUser().getId())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			AddressDto body = toDto.convert(address.get());
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<AddressDto>> get(@PathVariable Long userId){
		List<Address> addresses = addressService.byUser(userId);
		
		return new ResponseEntity<>(toDto.convert(addresses), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long userId){
		
		Optional<Address> address = addressService.one(id);
		if(!address.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Administrator user = address.get().getUser();
		if(user == null 
				|| !userId.equals( user.getId()) ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		addressService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<AddressDto> add(
			@RequestBody AddressDto address,
			@PathVariable Long userId){
		
		if(address.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Administrator> user = userService.one(userId);
		if(!user.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Administrator toUpdate = user.get();
		
		Address converted = toAddress.convert(address);
		Address persisted = addressService.save(converted);
		
		toUpdate.addAddress(persisted);
		addressService.save(persisted);
		userService.save(toUpdate);
		
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> edit(
			@PathVariable Long id,
			@RequestBody AddressDto address){
		
		if(!id.equals(address.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Address converted = toAddress.convert(address);
		Address persisted = addressService.save(converted);
		
		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}
	*/
}
