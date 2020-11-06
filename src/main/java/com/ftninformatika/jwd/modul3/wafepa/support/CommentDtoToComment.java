package com.ftninformatika.jwd.modul3.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.wafepa.model.Comment;
import com.ftninformatika.jwd.modul3.wafepa.repository.ApartmentRepository;
import com.ftninformatika.jwd.modul3.wafepa.repository.GuestRepository;

import com.ftninformatika.jwd.modul3.wafepa.web.dto.CommentDto;

@Component
public class CommentDtoToComment implements Converter<CommentDto,Comment> {
@Autowired
private ApartmentRepository apartmentRepository;
@Autowired
private GuestRepository guestRepository;
	@Override
	public Comment convert(CommentDto source) {
		Comment comment=new Comment();
		comment.setApartment(apartmentRepository.getOne(source.getApartmentId()));
		comment.setAssessment(source.getAssessment());
		comment.setId(source.getId());
		comment.setGuest(guestRepository.getOne(source.getGuestId()));
		return comment;
	}
public List<Comment> convert(List<CommentDto> source){
	List<Comment> comments=new ArrayList<>();
	for(CommentDto dto:source) {
		comments.add(convert(dto));
	}
	return comments;
}
}
