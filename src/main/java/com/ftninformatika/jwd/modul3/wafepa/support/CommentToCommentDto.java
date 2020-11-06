package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Comment;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.CommentDto;

@Component
public class CommentToCommentDto implements Converter<Comment,CommentDto>{

	@Override
	public CommentDto convert(Comment source) {
		CommentDto dto=new CommentDto();
		dto.setApartmentId(source.getApartment().getId());
		dto.setAssessment(source.getAssessment());
		dto.setGuestId(source.getGuest().getId());
		dto.setText(source.getText());
		dto.setId(source.getId());
		return dto;
	}
public List<CommentDto> convert(List<Comment>source){
	List <CommentDto> dtos=new ArrayList<>();
	for(Comment comment:source) {
		dtos.add(convert(comment));
	}
	return dtos;
}
}
