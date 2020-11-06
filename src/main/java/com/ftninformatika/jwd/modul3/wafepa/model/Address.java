package com.ftninformatika.jwd.modul3.wafepa.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String number;
private String postcode;
private String city;

public Address() {
	super();
}

public Address(String street, String number, String postcode, String city) {
	super();
	this.street = street;
	this.number = number;
	this.postcode = postcode;
	this.city = city;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

}
