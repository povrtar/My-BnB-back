package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AddressDto;

@Component
public class AddressToAddressDto implements Converter<Address, AddressDto> {

	@Override
	public AddressDto convert(Address source) {
		AddressDto target = new AddressDto();
		target.setId(source.getId());
		target.setNumber(source.getNumber());
		target.setStreet(source.getStreet());
		return target;
	}
	
	public List<AddressDto> convert(List<Address> source){
		List<AddressDto> target = new ArrayList<>();
		
		for(Address a : source) {
			AddressDto dto = convert(a);
			target.add(dto);
		}
		
		return target;
	}

}
