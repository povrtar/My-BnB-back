package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

public interface AdministratorService {
	Optional<Administrator> one(Long id);	
	List<Administrator> all();
	Page<Administrator> all(int pageNum);
	Administrator save(Administrator administrator);
	void delete(Long id);
	Optional<Administrator> byUsername(String username);
	boolean changePassword(Long id, UserPasswordChangeDto changeDto);
}
