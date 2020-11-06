package com.ftninformatika.jwd.modul3.wafepa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Availability {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
private Apartment apartment;
private LocalDate date;

public Availability() {
	super();
}

public Availability(Apartment apartment, LocalDate date) {
	super();
	this.apartment = apartment;
	this.date = date;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Apartment getApartment() {
	return apartment;
}

public void setApartment(Apartment apartment) {
	this.apartment = apartment;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}

}
