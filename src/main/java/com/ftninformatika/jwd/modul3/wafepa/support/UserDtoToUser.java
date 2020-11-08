package com.ftninformatika.jwd.modul3.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Role;
import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.service.UserService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserDto;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

	@Autowired
	private UserService userService;
@Autowired
private ApartmentDtoToApartment toApartmens;
	
	@Override
	public User convert(UserDto source) {
		User target = null;
		if(source.getId() != null) {
			target = userService.one(source.getId()).get();
		}
		
		if(target == null) { 
			target = new User();
		}
			target.setId(source.getId());	
		target.setUsername(source.getUsername());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		
		switch(source.getRole().toLowerCase()) {
		case "administrator":
			target.setRole(Role.ADMINISTRATOR);
			break;
		case "guest":
			target.setRole(Role.GUEST);
			break;
		case "host":
			target.setRole(Role.HOST);
			break;
		}
		
		return target;
	}


}
