package com.ftninformatika.jwd.modul3.wafepa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch=FetchType.LAZY)
private Apartment apartment;
private LocalDate checkInDate;
private Long nights;
private Double totalPrice;
@ManyToOne(fetch=FetchType.LAZY)
private Guest guest;
@Enumerated(EnumType.STRING)
private ReservationStatus reservationStatus;
public Reservation() {
	super();
}
public Reservation(Apartment apartment, LocalDate checkInDate, Long nights, Guest guest) {
	super();
	this.apartment = apartment;
	this.checkInDate = checkInDate;
	this.nights = nights;
	this.guest = guest;
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
public LocalDate getCheckInDate() {
	return checkInDate;
}
public void setCheckInDate(LocalDate checkInDate) {
	this.checkInDate = checkInDate;
}
public Long getNights() {
	return nights;
}
public void setNights(Long nights) {
	this.nights = nights;
}
public Double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(Double totalPrice) {
	this.totalPrice = totalPrice;
}
public Guest getGuest() {
	return guest;
}
public void setGuest(Guest guest) {
	this.guest = guest;
}
public ReservationStatus getReservationStatus() {
	return reservationStatus;
}
public void setReservationStatus(ReservationStatus reservationStatus) {
	this.reservationStatus = reservationStatus;
}



}
