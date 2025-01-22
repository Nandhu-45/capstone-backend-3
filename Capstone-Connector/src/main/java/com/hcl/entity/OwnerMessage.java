package com.hcl.entity;

import java.time.LocalDate;

public class OwnerMessage {

	private int id;
	private LocalDate msgedDate;
	private String adminMsg;
	private String userEmail;
	public OwnerMessage() {
		
	}
	public OwnerMessage(int id, LocalDate msgedDate, String adminMsg, String userEmail) {
		super();
		this.id = id;
		this.msgedDate = msgedDate;
		this.adminMsg = adminMsg;
		this.userEmail = userEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getMsgedDate() {
		return msgedDate;
	}
	public void setMsgedDate(LocalDate msgedDate) {
		this.msgedDate = msgedDate;
	}
	public String getAdminMsg() {
		return adminMsg;
	}
	public void setAdminMsg(String adminMsg) {
		this.adminMsg = adminMsg;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
