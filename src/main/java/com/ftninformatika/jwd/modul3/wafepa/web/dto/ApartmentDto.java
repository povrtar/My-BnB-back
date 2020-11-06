package com.ftninformatika.jwd.modul3.wafepa.web.dto;

import java.time.LocalDate;
import java.util.List;

public class ApartmentDto {
	private Long id;
private String type;
private Long numberOfRooms;
private Long numberOfGuests;
private Long locationId;
private List<LocalDate> availability;
private Long hostId;
private List<ReservationDto> reservationDto; 
private Double pricePerNight;
private Boolean status;
private List<AmenityDto> amenities;
private String checkIn;
private String checkOut;
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
public Long getLocationId() {
	return locationId;
}
public void setLocationId(Long locationId) {
	this.locationId = locationId;
}

public List<LocalDate> getAvailability() {
	return availability;
}
public void setAvailability(List<LocalDate> availability) {
	this.availability = availability;
}
public Long getHostId() {
	return hostId;
}
public void setHostId(Long hostId) {
	this.hostId = hostId;
}

public Double getPricePerNight() {
	return pricePerNight;
}
public void setPricePerNight(Double pricePerNight) {
	this.pricePerNight = pricePerNight;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public Long getNumberOfGuests() {
	return numberOfGuests;
}
public void setNumberOfGuests(Long numberOfGuests) {
	this.numberOfGuests = numberOfGuests;
}


public String getCheckIn() {
	return checkIn;
}
public void setCheckIn(String checkIn) {
	this.checkIn = checkIn;
}
public String getCheckOut() {
	return checkOut;
}
public void setCheckOut(String checkOut) {
	this.checkOut = checkOut;
}
public List<AmenityDto> getAmenities() {
	return amenities;
}
public void setAmenities(List<AmenityDto> amenities) {
	this.amenities = amenities;
}
public List<ReservationDto> getReservationDto() {
	return reservationDto;
}
public void setReservationDto(List<ReservationDto> reservationDto) {
	this.reservationDto = reservationDto;
}
@Override
public String toString() {
	return "ApartmentDto [id=" + id + ", type=" + type + ", numberOfRooms=" + numberOfRooms + ", numberOfGuests="
			+ numberOfGuests + ", locationId=" + locationId +  ", hostId=" + hostId
			+ ", pricePerNight=" + pricePerNight + ", status=" + status +  ", checkIn="
			+ checkIn + ", checkOut=" + checkOut + "]";
}


}
