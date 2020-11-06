package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.repository.AddressRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.AddressService;

@Service
public class JpaAddressService implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Optional<Address> one(Long id) {
		return addressRepository.findById(id);
	}

	@Override
	public List<Address> all() {
		return addressRepository.findAll();
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public void delete(Long id) {
		addressRepository.deleteById(id);
	}



}
