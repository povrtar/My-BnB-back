package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;
import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;

public interface AmenityService {
	Optional<Amenity> one(Long id);	
	List<Amenity> all();
	Amenity save(Amenity amenity);
	Amenity delete(Long id);
	
}
