package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;

public interface AddressService {
	Optional<Address> one(Long id);	
	List<Address> all();
	Address save(Address Address);
	void delete(Long id);
	
}
