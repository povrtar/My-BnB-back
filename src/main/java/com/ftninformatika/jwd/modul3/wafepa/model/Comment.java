package com.ftninformatika.jwd.modul3.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private User guest;
@ManyToOne(fetch=FetchType.LAZY)
private Apartment apartment;
private String text;
private Long assessment;

public Comment() {
	super();
}

public Comment(Long id, String text, Long assessment) {
	super();
	this.id = id;
	this.text = text;
	this.assessment = assessment;
}

public Comment(User guest, Apartment apartment, String text, Long assessment) {
	super();
	this.guest = guest;
	this.apartment = apartment;
	this.text = text;
	this.assessment = assessment;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public User getGuest() {
	return guest;
}

public void setGuest(User guest) {
	this.guest = guest;
}

public Apartment getApartment() {
	return apartment;
}

public void setApartment(Apartment apartment) {
	this.apartment = apartment;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public Long getAssessment() {
	return assessment;
}

public void setAssessment(Long assessment) {
	this.assessment = assessment;
}

}
