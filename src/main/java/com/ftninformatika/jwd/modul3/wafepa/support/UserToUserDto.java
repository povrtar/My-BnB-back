package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Role;
import com.ftninformatika.jwd.modul3.wafepa.model.User;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.UserDto;

@Component
public class UserToUserDto implements Converter<User, UserDto>{

	@Override
	public UserDto convert(User source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setUsername(source.getUsername());
		target.setGender(source.getGender().toString());
		target.setRole(source.getRole().toString());
		return target;
	}

	public List<UserDto> convert(List<User> users){
		List<UserDto> usersDto=new ArrayList<>();
		for(User user:users) {
			usersDto.add(convert(user));
		}
		return usersDto;
	}
}
