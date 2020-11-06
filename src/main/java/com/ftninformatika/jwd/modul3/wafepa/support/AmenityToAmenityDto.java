package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Amenity;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.AmenityDto;

@Component
public class AmenityToAmenityDto implements Converter<Amenity,AmenityDto> {

	@Override
	public AmenityDto convert(Amenity source) {
		AmenityDto dto=new AmenityDto();
		dto.setId(source.getId());
		dto.setName(source.getName());
		return dto;
	}
public List<AmenityDto> convert(List<Amenity> amenities) {
List<AmenityDto> dtos=new ArrayList<>();
	for(Amenity amenity:new ArrayList<Amenity>(amenities)) {
		dtos.add(convert(amenity));
	}
	return dtos;
}
}
