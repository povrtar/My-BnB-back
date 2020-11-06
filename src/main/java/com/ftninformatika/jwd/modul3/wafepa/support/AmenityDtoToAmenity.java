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
public class AmenityDtoToAmenity implements Converter <AmenityDto,Amenity> {

	@Override
	public Amenity convert(AmenityDto source) {
		Amenity amenity=new Amenity();
		amenity.setId(source.getId());
		amenity.setName(source.getName());
		return amenity;
	}
public List<Amenity> convert(List<AmenityDto> source){
	List <Amenity>amenities=new ArrayList<>();
	for(AmenityDto dto:source) {
		amenities.add(convert(dto));
	}
	return amenities;
}
}
