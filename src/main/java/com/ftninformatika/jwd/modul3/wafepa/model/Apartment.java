package com.ftninformatika.jwd.modul3.wafepa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Apartment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String type;
private Long numberOfRooms;
private Long numberOfGuests;
@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "location_id")
private Location location;
@Transient
private List<LocalDate> availability;
@ManyToOne(fetch = FetchType.EAGER)
private User host;
@OneToMany(mappedBy="apartment",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Comment> comments;
private Double pricePerNight;
private String checkInTime;
private String checkOutTime;

private Boolean status;
@ManyToMany
List<Amenity> amenitiesForApartment;
@OneToMany(mappedBy="apartment",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
List<Reservation> reservations;
@ManyToMany
private Set<User> guests;

public Apartment() {
}
public Apartment(String type, Long numberOfRooms, Long numberOfGuests, Location location) {
	super();
	this.type = type;
	this.numberOfRooms = numberOfRooms;
	this.numberOfGuests = numberOfGuests;
	this.location = location;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}



public Long getNumberOfRooms() {
	return numberOfRooms;
}
public void setNumberOfRooms(Long numberOfRooms) {
	this.numberOfRooms = numberOfRooms;
}
public Long getNumberOfGuests() {
	return numberOfGuests;
}
public void setNumberOfGuests(Long numberOfGuests) {
	this.numberOfGuests = numberOfGuests;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
}

public List<Comment> getComments() {
	return comments;
}

public List<LocalDate> getAvailability() {
	List<LocalDate> availabilityDates=new ArrayList<>();
	if (this.reservations!=null) {
		for (Reservation reservation:this.reservations) {	
	
		if(!reservation.getReservationStatus().equals(ReservationStatus.CANCELED)||
				!reservation.getReservationStatus().equals(ReservationStatus.REJECTED)) {	
		LocalDate date=reservation.getCheckInDate();
		for(Long i=0L;i<reservation.getNights();i++) {
		availabilityDates.add(date);
		date=date.plusDays(1L);
		}
		}
		
	}
	this.availability=availabilityDates;}
	else{
		this.availability=null;
	}
	return availability;
}
public void setAvailability(List<LocalDate> availability) {
	this.availability = availability;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}


public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}

public List<Reservation> getReservations() {
	return reservations;
}
public void setReservations(List<Reservation> reservations) {
	this.reservations=reservations;
}

public Double getPricePerNight() {
	return pricePerNight;
}
public void setPricePerNight(Double pricePerNight) {
	this.pricePerNight = pricePerNight;
}

public List<Amenity> getAmenitiesForApartment() {
	return amenitiesForApartment;
}
public void setAmenitiesForApartment(List<Amenity> amenitiesForApartment) {
	this.amenitiesForApartment = amenitiesForApartment;
}


public User getHost() {
	return host;
}
public void setHost(User host) {
	this.host = host;
}
public Set<User> getGuests() {
	return guests;
}
public void setGuests(Set<User> guests) {
	this.guests = guests;
}
public String getCheckInTime() {
	return checkInTime;
}
public void setCheckInTime(String checkInTime) {
	this.checkInTime = checkInTime;
}
public String getCheckOutTime() {
	return checkOutTime;
}
public void setCheckOutTime(String checkOutTime) {
	this.checkOutTime = checkOutTime;
}
@Override
public String toString() {
	return "Apartment [id=" + id + ", type=" + type + ", numberOfRooms=" + numberOfRooms + ", numberOfGuests="
			+ numberOfGuests + ", location=" + location + ", availability=" + availability
			+ ", host=" + host + ", pricePerNight=" + pricePerNight + ", checkInDate=" + checkInTime + ", checkOutDate="
			+ checkOutTime + ", status=" + status + "]";
}


}
