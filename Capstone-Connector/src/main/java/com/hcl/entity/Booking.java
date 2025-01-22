package com.hcl.entity;

import java.time.LocalDate;

public class Booking {
	
	private int bookingId;
	private String pickUpLocation;
	private String droppingLocation;
	private int kms;
	private LocalDate bookingDate;
	private String regNumber;
	private String userName;
	private String userEmail;
	public Booking() {
		
	}
	public Booking(int bookingId, String pickUpLocation, String droppingLocation, int kms, LocalDate bookingDate,
			String regNumber, String userName, String userEmail) {
		super();
		this.bookingId = bookingId;
		this.pickUpLocation = pickUpLocation;
		this.droppingLocation = droppingLocation;
		this.kms = kms;
		this.bookingDate = bookingDate;
		this.regNumber = regNumber;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public String getDroppingLocation() {
		return droppingLocation;
	}
	public void setDroppingLocation(String droppingLocation) {
		this.droppingLocation = droppingLocation;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
