package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import com.ftninformatika.jwd.modul3.wafepa.model.Location;

public interface LocationService {

	List<Location> all();	
	Optional<Location> one(Long id);
	Location save(Location Location);
	Location delete(Long id);
	
	
}
