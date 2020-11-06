package com.ftninformatika.jwd.modul3.wafepa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.wafepa.model.Comment;

public interface CommentService {

	Page<Comment> all(int pageNum);	
	Optional<Comment> one(Long id);
	Comment save(Comment comment);
	Comment delete(Long id);
	
	
}
