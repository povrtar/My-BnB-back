package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Host;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

public interface HostService {
	Optional<Host> one(Long id);	
	List<Host> all();
	Page<Host> all(int pageNum);
	Host save(Host host);
	void delete(Long id);
	Optional<Host> byUsername(String username);
	boolean changePassword(Long id, UserPasswordChangeDto changeDto);
}
