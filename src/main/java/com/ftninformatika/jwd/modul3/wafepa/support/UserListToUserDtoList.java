package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Administrator;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserDto;

@Component
public class UserListToUserDtoList implements Converter<List<Administrator>, List<UserDto>>{
	@Autowired
	private AdministratorToUserDto toDto;
	
	@Override
	public List<UserDto> convert(List<Administrator> source) {
		List<UserDto> target = new ArrayList<>();
		
		for(Administrator u : source) {
			UserDto dto = toDto.convert(u);
			target.add(dto);
		}
		
		return target;
	}

}
