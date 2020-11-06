package com.ftninformatika.jwd.modul3.wafepa.web.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.wafepa.model.Apartment;
import com.ftninformatika.jwd.modul3.wafepa.model.Comment;
import com.ftninformatika.jwd.modul3.wafepa.service.CommentService;
import com.ftninformatika.jwd.modul3.wafepa.support.CommentDtoToComment;
import com.ftninformatika.jwd.modul3.wafepa.support.CommentToCommentDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.ApartmentDto;
import com.ftninformatika.jwd.modul3.wafepa.web.dto.CommentDto;

@RestController
@RequestMapping("/api/comments")
public class ApiCommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentToCommentDto toDto;
	@Autowired
	private CommentDtoToComment toEntity;
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<CommentDto>> getComments(
	/*		@RequestParam(required=false) LocalDate checkIn,
			@RequestParam(required=false) LocalDate checkOut,
			@RequestParam(required=false) String city,
			@RequestParam(required=false) Double priceFrom,
			@RequestParam(required=false) Double priceTo,
			@RequestParam(required=false) Long numberOfRoomsMin,
			@RequestParam(required=false) Long numberOfRoomsMax,
			*/
			@RequestParam(value="pageNum", defaultValue="0") int pageNum){
		
		Page<Comment> commentsPage = null;
		/*
		if(checkIn != null || checkOut != null || city != null ||priceFrom!=null||priceTo!=null||
				numberOfRoomsMin!=null ||numberOfRoomsMax!=null) {
			apartmentsPage = apartmentService.search(checkIn,checkOut,city,priceFrom,priceTo,numberOfRoomsMin,numberOfRoomsMax,pageNum);
		}
		else {*/
			 commentsPage=commentService.all(pageNum);
	//	}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(commentsPage.getTotalPages()) );
		
		return new ResponseEntity<>(
				toDto.convert(commentsPage.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<CommentDto> getRecord(@PathVariable Long id){
		Optional<Comment> comment = commentService.one(id);
		if(!comment.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(comment.get()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<CommentDto> delete(@PathVariable Long id){
		Comment deleted = commentService.delete(id);
		
		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDto.convert(deleted),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<CommentDto> add(
			@Validated @RequestBody CommentDto dto){
		
		Comment persisted= commentService.save(
				toEntity.convert(dto));
		
		return new ResponseEntity<>(
				toDto.convert(persisted), 
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<CommentDto> edit(
			@Validated @RequestBody CommentDto dto,
			@PathVariable Long id){
		
		if(!id.equals(dto.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Comment persisted = commentService.save(
				toEntity.convert(dto));
		
		return new ResponseEntity<>(
				toDto.convert(persisted),
				HttpStatus.OK);
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
