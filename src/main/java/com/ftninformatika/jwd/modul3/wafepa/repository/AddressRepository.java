package com.ftninformatika.jwd.modul3.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	

}
