package com.ftninformatika.jwd.modul3.wafepa.web.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.ftninformatika.jwd.modul3.wafepa.model.Gender;

public class UserDto {
	private Long id;
	@NotBlank
	private String username;
	@NotEmpty
	@Size(min=3, max=50)
	private String firstName;
	@Size(min=3, max=50)
	private String lastName;
	private String gender;
	private String role;
	private List<ApartmentDto> apartmentsForRent;
	private List<ApartmentDto> rentedApartments;
	private List<ReservationDto> userReservations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<ApartmentDto> getApartmentsForRent() {
		return apartmentsForRent;
	}
	public void setApartmentsForRent(List<ApartmentDto> apartmentsForRent) {
		this.apartmentsForRent = apartmentsForRent;
	}
	public List<ApartmentDto> getRentedApartments() {
		return rentedApartments;
	}
	public void setRentedApartments(List<ApartmentDto> rentedApartments) {
		this.rentedApartments = rentedApartments;
	}
	public List<ReservationDto> getUserReservations() {
		return userReservations;
	}
	public void setUserReservations(List<ReservationDto> userReservations) {
		this.userReservations = userReservations;
	}
	
	
}
