package com.ftninformatika.jwd.modul3.wafepa.repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
	
	@Query("SELECT a FROM Apartment a WHERE  "
		+ "(:checkIn IS NULL  OR a.checkInTime like :checkIn ) AND   "
			+"(:checkOut IS NULL OR a.checkOutTime like :checkOut) AND "
			+ "(:city IS NULL or a.location.address.city like :city ) AND "
			+ "(:priceFrom IS NULL OR a.pricePerNight >= :priceFrom) AND "
			+ "(:priceTo IS NULL OR a.pricePerNight <= :priceTo ) AND "
			+ "(:numberOfRoomsMin IS NULL OR a.numberOfRooms>= :numberOfRoomsMin ) AND"
			+ "(:numberOfRoomsMax IS NULL OR a.numberOfRooms<= :numberOfRoomsMax ) "
			)
	Page<Apartment> search(
			@Param("checkIn") String checkIn, 
			@Param("checkOut") String checkOut,
			@Param("city") String city,
			@Param("priceFrom")Double priceFrom,
			@Param("priceTo")Double priceTo,
			@Param("numberOfRoomsMin")Long numberOfRoomsMin,
			@Param("numberOfRoomsMax")Long numberOfRoomsMax,
			
			Pageable pageRequest);

}
