package com.ftninformatika.jwd.modul3.wafepa.web.dto;

public class CommentDto {
private Long id;
	private Long guestId;
	private Long apartmentId;
	private String text;
	private Long assessment;
	public Long getGuestId() {
		return guestId;
	}
	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}
	public Long getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(Long apartmentId) {
		this.apartmentId = apartmentId;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
