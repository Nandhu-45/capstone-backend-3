package com.hcl.entity;

import java.time.LocalDate;

public class BookingConfirmation {
	
	private int  confirmId;
    private String pickUpLocation;
    private String droppingLocation;
    private int kms;
    private LocalDate  confirmDate;
    private String regNumber;
    private String userName;
    private String userEmail;
	public BookingConfirmation() {
		
	}
	public BookingConfirmation(int confirmId, String pickUpLocation, String droppingLocation, int kms,
			LocalDate confirmDate, String regNumber, String userName, String userEmail) {
		super();
		this.confirmId = confirmId;
		this.pickUpLocation = pickUpLocation;
		this.droppingLocation = droppingLocation;
		this.kms = kms;
		this.confirmDate = confirmDate;
		this.regNumber = regNumber;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public int getConfirmId() {
		return confirmId;
	}
	public void setConfirmId(int confirmId) {
		this.confirmId = confirmId;
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
	public LocalDate getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(LocalDate confirmDate) {
		this.confirmDate = confirmDate;
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
