package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Guest;
import com.ftninformatika.jwd.modul3.wafepa.repository.GuestRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.GuestService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

@Service
public class JpaGuestService implements GuestService{

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<Guest> one(Long id) {
		return guestRepository.findById(id);
	}

	@Override
	public List<Guest> all() {
		return guestRepository.findAll();
	}

	@Override
	public Guest save(Guest user) { return guestRepository.save(user); }

	@Override
	public void delete(Long id) {
		guestRepository.deleteById(id);
	}

	@Override
	public Optional<Guest> byUsername(String username) {
		return guestRepository.findFirstByUsername(username);
	}

	@Override
	public boolean changePassword(Long id, UserPasswordChangeDto changeDto) {
		Optional<Guest> result = guestRepository.findById(id);
		
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		Guest user = result.get();
		
		if(!user.getUsername().equals(changeDto.getUsername())
			|| !user.getPassword().equals(changeDto.getOldPassword())){
			return false;
		}

		// ubacen deo koda zbog greske koja se desavala ako kroz ubacivanje podataka dva puta
		// kriptujemo lozinku
		String encodedPass = passwordEncoder.encode(changeDto.getPassword());
		user.setPassword(encodedPass);

		guestRepository.save(user);
		
		return true;
	}

	@Override
	public Page<Guest> all(int pageNum) {
		return guestRepository.findAll(PageRequest.of(pageNum, 10));
	}

}
