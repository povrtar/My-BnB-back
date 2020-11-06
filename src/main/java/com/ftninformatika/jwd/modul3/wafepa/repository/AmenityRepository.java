package com.ftninformatika.jwd.modul3.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

}
