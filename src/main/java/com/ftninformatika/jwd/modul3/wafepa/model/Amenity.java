package com.ftninformatika.jwd.modul3.wafepa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Amenity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
@ManyToMany
private Set<Apartment> apartmentsWithAmanity;


public Amenity() {
	super();
}

public Amenity(Long id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public Amenity(String name) {
	super();
	this.name = name;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<Apartment> getApartmentsWithAmanity() {
	return apartmentsWithAmanity;
}

public void setApartmentsWithAmanity(Set<Apartment> apartmentsWithAmanity) {
	this.apartmentsWithAmanity = apartmentsWithAmanity;
}

}
