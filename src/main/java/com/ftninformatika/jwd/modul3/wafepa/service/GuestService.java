package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Guest;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

public interface GuestService {
	Optional<Guest> one(Long id);	
	List<Guest> all();
	Page<Guest> all(int pageNum);
	Guest save(Guest guest);
	void delete(Long id);
	Optional<Guest> byUsername(String username);
	boolean changePassword(Long id, UserPasswordChangeDto changeDto);
}
