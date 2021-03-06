package com.ftninformatika.jwd.modul3.wafepa.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated (EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy="host",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	List<Apartment> apartmentsForRent;
	@OneToMany(mappedBy = "guest",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	List<Reservation> userReservations;
	
	public User(String username, String password, String firstName, String lastName, Gender gender) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public User() {
	
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Apartment> getApartmentsForRent() {
		return apartmentsForRent;
	}
	public void setApartmentsForRent(List<Apartment> apartmentsForRent) {
		this.apartmentsForRent = apartmentsForRent;
	}
	public List<Reservation> getUserReservations() {
		return userReservations;
	}
	public void setUserReservations(List<Reservation> userReservations) {
		this.userReservations = userReservations;
	}
	
	
}
