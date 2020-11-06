package com.ftninformatika.jwd.modul3.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;
import com.ftninformatika.jwd.modul3.wafepa.service.AdministratorService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserDto;

@Component
public class UserDtoToAdministrator implements Converter<UserDto, Administrator> {

	@Autowired
	private AdministratorService adminService;

	
	@Override
	public Administrator convert(UserDto source) {
		Administrator target = null;
		if(source.getId() != null) {
			target = adminService.one(source.getId()).get();
		}
		
		// čak i da je došao dto sa popunjenim ID
		// moguće je da ne postoji, pa ga onda treba kreirati
		if(target == null) { 
			target = new Administrator();
		}
			target.setId(source.getId());	
		target.setUsername(source.getUsername());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setGender(source.getGender());
		
		return target;
	}

}
