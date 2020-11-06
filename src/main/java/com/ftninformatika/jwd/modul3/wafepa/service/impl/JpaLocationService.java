package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Location;
import com.ftninformatika.jwd.modul3.wafepa.repository.LocationRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.LocationService;
@Service
public class JpaLocationService implements LocationService {
@Autowired
private LocationRepository locationRepository;
	@Override
	public List<Location> all() {
		return locationRepository.findAll();
	}

	@Override
	public Optional<Location> one(Long id) {
		return locationRepository.findById(id);
	}

	@Override
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location delete(Long id) {
		Optional<Location> location=locationRepository.findById(id);
		if(location.isPresent()) {
			locationRepository.deleteById(id);
			return location.get();
		}
		return null;
	}

}
