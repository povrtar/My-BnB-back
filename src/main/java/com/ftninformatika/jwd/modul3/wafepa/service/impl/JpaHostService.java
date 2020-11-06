package com.ftninformatika.jwd.modul3.wafepa.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Host;
import com.ftninformatika.jwd.modul3.wafepa.repository.HostRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.HostService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

@Service
public class JpaHostService implements HostService{

	@Autowired
	private HostRepository hostRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<Host> one(Long id) {
		return hostRepository.findById(id);
	}

	@Override
	public List<Host> all() {
		return hostRepository.findAll();
	}

	@Override
	public Host save(Host user) { return hostRepository.save(user); }

	@Override
	public void delete(Long id) {
		hostRepository.deleteById(id);
	}

	@Override
	public Optional<Host> byUsername(String username) {
		return hostRepository.findFirstByUsername(username);
	}

	@Override
	public boolean changePassword(Long id, UserPasswordChangeDto changeDto) {
		Optional<Host> result = hostRepository.findById(id);
		
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		Host user = result.get();
		
		if(!user.getUsername().equals(changeDto.getUsername())
			|| !user.getPassword().equals(changeDto.getOldPassword())){
			return false;
		}

		// ubacen deo koda zbog greske koja se desavala ako kroz ubacivanje podataka dva puta
		// kriptujemo lozinku
		String encodedPass = passwordEncoder.encode(changeDto.getPassword());
		user.setPassword(encodedPass);

		hostRepository.save(user);
		
		return true;
	}

	@Override
	public Page<Host> all(int pageNum) {
		return hostRepository.findAll(PageRequest.of(pageNum, 10));
	}

}
