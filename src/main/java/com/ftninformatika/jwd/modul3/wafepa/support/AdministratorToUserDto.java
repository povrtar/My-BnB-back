package com.ftninformatika.jwd.modul3.wafepa.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserDto;

@Component
public class AdministratorToUserDto implements Converter<Administrator, UserDto>{

	@Override
	public UserDto convert(Administrator source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setUsername(source.getUsername());
		target.setGender(source.getGender());
		
		return target;
	}

	
}
