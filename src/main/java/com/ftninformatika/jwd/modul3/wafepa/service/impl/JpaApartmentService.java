package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.repository.ApartmentRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.ApartmentService;

@Service
public class JpaApartmentService implements ApartmentService {
	
	@Autowired
	private ApartmentRepository apartmentRepository;

	@Override
	public Optional<Apartment> one(Long id) {
		return apartmentRepository.findById(id);
	}

	@Override
	public Apartment save(Apartment apartment) {
		return apartmentRepository.save(apartment);
	}

	@Override
	public List<Apartment> save(List<Apartment> activities) {
		return apartmentRepository.saveAll(activities);
	}

	@Override
	public Apartment delete(Long id) {
		Optional<Apartment> apartment =apartmentRepository.findById(id);
		if(apartment.isPresent()) {
			apartmentRepository.deleteById(id);
			return apartment.get();
		}
		
		return null;
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Apartment> search(String checkIn, String checkOut, String city, Double priceFrom, Double priceTo,
			Long numberOfRoomsMin, Long numberOfRoomsMax, int page) {
		return apartmentRepository.search(checkIn,checkOut,city,priceFrom,priceTo,numberOfRoomsMin,numberOfRoomsMax, PageRequest.of(page, 5));
	}

	@Override
	public Page<Apartment> all(int pageNum) {
		
		return apartmentRepository.findAll(PageRequest.of(pageNum, 20));
	}

	

	
}
