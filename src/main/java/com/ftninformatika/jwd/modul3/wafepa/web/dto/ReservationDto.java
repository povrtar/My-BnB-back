package com.ftninformatika.jwd.modul3.wafepa.web.dto;

import java.time.LocalDate;
import java.util.Date;

import com.ftninformatika.jwd.modul3.wafepa.model.ReservationStatus;


public class ReservationDto {
	private Long id;
private Long apartmentId;
private Long guestId;
private LocalDate checkIn;
private Long nights;
private Double totalPrice;
private String resStatus;
public Long getApartmentId() {
	return apartmentId;
}
public void setApartmentId(Long apartmentId) {
	this.apartmentId = apartmentId;
}
public Long getGuestId() {
	return guestId;
}
public void setGuestId(Long guestId) {
	this.guestId = guestId;
}
public LocalDate getCheckIn() {
	return checkIn;
}
public void setCheckIn(LocalDate checkIn) {
	this.checkIn = checkIn;
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

public String getResStatus() {
	return resStatus;
}
public void setResStatus(String resStatus) {
	this.resStatus = resStatus;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}



}
