package com.ftninformatika.jwd.modul3.wafepa.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.wafepa.model.Comment;
import com.ftninformatika.jwd.modul3.wafepa.repository.CommentRepository;
import com.ftninformatika.jwd.modul3.wafepa.service.CommentService;
@Service
public class JpaCommentService implements CommentService {
@Autowired
private CommentRepository commentRepository;
	@Override
	public Page<Comment> all(int pageNum) {
			return commentRepository.findAll(PageRequest.of(pageNum, 5));
	}

	@Override
	public Optional<Comment> one(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	public Comment save(Comment comment) {
		
		return commentRepository.save(comment);
	}

	

	@Override
	public Comment delete(Long id) {
		Optional<Comment> comment=commentRepository.findById(id);
		 if(comment.isPresent()) {
			 commentRepository.deleteById(id);
			 return comment.get();
		 }
		 return null;
	}

	

}
