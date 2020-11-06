package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.repository.AmenityRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.AmenityService;
@Service
public class JpaAmenityService implements AmenityService {
@Autowired
private AmenityRepository amenityRepository;
	@Override
	public Optional<Amenity> one(Long id) {
		return amenityRepository.findById(id);
	}

	@Override
	public List<Amenity> all() {
		return amenityRepository.findAll();
	}

	@Override
	public Amenity save(Amenity amenity) {
		return amenityRepository.save(amenity);
	}

	@Override
	public Amenity delete(Long id) {
		Optional<Amenity> amenity=amenityRepository.findById(id);
		if(amenity.isPresent()) {
			amenityRepository.deleteById(id);
		}
		return amenity.get();
		}

}
