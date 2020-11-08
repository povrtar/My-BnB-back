package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserPasswordChangeDto;

public interface UserService {
	Optional<User> one(Long id);	
	List<User> all();
	Page<User> all(int pageNum);
	User save(User administrator);
	void delete(Long id);
	Optional<User> byUsername(String username);
	boolean changePassword(Long id, UserPasswordChangeDto changeDto);
}
