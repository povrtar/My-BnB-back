package com.ftninformatika.jwd.modul3.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
