package com.ftninformatika.jwd.modul3.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Address;
import com.ftninformatika.jwd.modul3.wafepa.service.AddressService;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AddressDto;

@Component
public class AddressDtoToAddress implements Converter<AddressDto, Address> {
	
	@Autowired
	private AddressService addressService;

	@Override
	public Address convert(AddressDto source) {
		Long id = source.getId();
		Address target = id == null ? new Address() : addressService.one(id).get();
		
		if(target != null) {
			target.setId(id);
			target.setNumber(source.getNumber());
			target.setStreet(source.getStreet());
		}
		
		return target;
	}

}
