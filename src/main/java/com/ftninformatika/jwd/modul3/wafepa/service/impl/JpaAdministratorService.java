package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.repository.UserRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

@Service
public class JpaAdministratorService implements UserService{

	@Autowired
	private UserRepository adminRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<User> one(Long id) {
		return adminRepository.findById(id);
	}

	@Override
	public List<User> all() {
		return adminRepository.findAll();
	}

	@Override
	public User save(User user) { return adminRepository.save(user); }

	@Override
	public void delete(Long id) {
		adminRepository.deleteById(id);
	}

	@Override
	public Optional<User> byUsername(String username) {
		return adminRepository.findFirstByUsername(username);
	}

	@Override
	public boolean changePassword(Long id, UserPasswordChangeDto changeDto) {
		Optional<User> result = adminRepository.findById(id);
		
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		User user = result.get();
		
		if(!user.getUsername().equals(changeDto.getUsername())
			|| !user.getPassword().equals(changeDto.getOldPassword())){
			return false;
		}

		// ubacen deo koda zbog greske koja se desavala ako kroz ubacivanje podataka dva puta
		// kriptujemo lozinku
		String encodedPass = passwordEncoder.encode(changeDto.getPassword());
		user.setPassword(encodedPass);

		adminRepository.save(user);
		
		return true;
	}

	@Override
	public Page<User> all(int pageNum) {
		return adminRepository.findAll(PageRequest.of(pageNum, 10));
	}

}
