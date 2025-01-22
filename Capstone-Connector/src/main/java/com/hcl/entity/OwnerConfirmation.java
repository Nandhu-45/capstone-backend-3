package com.hcl.entity;

import java.time.LocalDate;

public class OwnerConfirmation {
	
	private int  ownerconfirmationId;
    private String pickUpLocation;
    private String droppingLocation;
    private int kms;
    private LocalDate  ownerconfirmationDate;
    private String regNumber;
    private String userName;
    private String userEmail;
	public OwnerConfirmation() {
		
	}
	public OwnerConfirmation(int ownerconfirmationId, String pickUpLocation, String droppingLocation, int kms,
			LocalDate ownerconfirmationDate, String regNumber, String userName, String userEmail) {
		super();
		this.ownerconfirmationId = ownerconfirmationId;
		this.pickUpLocation = pickUpLocation;
		this.droppingLocation = droppingLocation;
		this.kms = kms;
		this.ownerconfirmationDate = ownerconfirmationDate;
		this.regNumber = regNumber;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public int getOwnerconfirmationId() {
		return ownerconfirmationId;
	}
	public void setOwnerconfirmationId(int ownerconfirmationId) {
		this.ownerconfirmationId = ownerconfirmationId;
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
	public LocalDate getOwnerconfirmationDate() {
		return ownerconfirmationDate;
	}
	public void setOwnerconfirmationDate(LocalDate ownerconfirmationDate) {
		this.ownerconfirmationDate = ownerconfirmationDate;
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
