package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;

public interface ApartmentService {

	Page<Apartment> all(int pageNum);
	
	Optional<Apartment> one(Long id);
	Apartment save(Apartment apartment);
	List<Apartment> save(List<Apartment> apartment);
	Apartment delete(Long id);
	void delete(List<Long> ids);

	Page<Apartment> search(String checkIn, String checkOut, String city, Double priceFrom, Double priceTo,
			Long numberOfRoomsMin, Long numberOfRoomsMax, int page);
	
}
